
using AM.ApplicationCore.Interfaces;
using Microsoft.EntityFrameworkCore;

namespace AM.Infrastructure
{
    public class UnitOfWork : IUnitOfWork
    {
        private DbContext _context;
        private Type _RepoType;
        private bool disposedValue;

        public UnitOfWork(DbContext context, Type repoType)
        {
            _context = context;
            _RepoType = repoType;
        }

        public IGenericRepository<T> GenerateRepo<T>() where T : class
        {
            return (IGenericRepository<T>) Activator
                .CreateInstance(
                _RepoType.MakeGenericType(typeof(T)), _context
                );
        }

        public int Save()
        {
            return _context.SaveChanges();
        }

        protected virtual void Dispose(bool disposing)
        {
            if (!disposedValue)
            {
                if (disposing)
                {
                    _context.Dispose();
                }

                disposedValue = true;
            }
        }
        ~UnitOfWork()
        {
             Dispose(disposing: false);
        }

        public void Dispose()
        {
            Dispose(disposing: true);
            GC.SuppressFinalize(this);
        }
    }
}
