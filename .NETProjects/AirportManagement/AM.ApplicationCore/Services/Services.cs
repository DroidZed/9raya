using AM.ApplicationCore.Interfaces;
using System.Linq.Expressions;

namespace AM.ApplicationCore.Services
{
    public class Services<T> : IServices<T> where T : class
    {
        private IGenericRepository<T> _repository;
        private IUnitOfWork _unitOfWork;

        public Services(IUnitOfWork unitOfWork)
        {
            _repository = unitOfWork.GenerateRepo<T>();
            _unitOfWork = unitOfWork;
        }

        public void Add(T entity)
        {
            _repository.Add(entity);
        }

        public void Commit()
        {
            _unitOfWork.Save();
        }

        public void Delete(T entity)
        {
            _repository.Delete(entity);
        }

        public void Delete(Expression<Func<T, bool>> where)
        {
            _repository.Delete(where);
        }

        public T Get(Expression<Func<T, bool>> where)
        {
            return _repository.Get(where);
        }

        public IEnumerable<T> GetAll()
        {
            return _repository.GetAll();
        }

        public T GetById(params object[] keys)
        {
            return _repository.GetById(keys);
        }

        public IEnumerable<T> GetMany(Expression<Func<T, bool>> where)
        {
            return _repository.GetMany(where);
        }

        public void Update(T entity)
        {
            _repository.Update(entity);
        }
    }
}
