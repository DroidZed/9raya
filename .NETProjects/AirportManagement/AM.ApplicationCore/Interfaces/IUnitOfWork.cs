

namespace AM.ApplicationCore.Interfaces
{
    public interface IUnitOfWork: IDisposable
    {
        public IGenericRepository<T> GenerateRepo<T>() where T: class;
        public int Save();
    }
}
