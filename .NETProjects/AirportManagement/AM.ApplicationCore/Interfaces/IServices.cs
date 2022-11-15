using System.Linq.Expressions;

namespace AM.ApplicationCore.Interfaces
{
    public interface IServices<T> where T : class
    {
        public void Add(T entity);

        public T GetById(params object[] keys);

        public T Get(Expression<Func<T, bool>> where);

        public IEnumerable<T> GetMany(Expression<Func<T, bool>> where);

        public IEnumerable<T> GetAll();

        public void Update(T entity);

        public void Delete(T entity);

        public void Delete(Expression<Func<T, bool>> where);

        public void Commit();
    }
}
