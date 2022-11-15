using AM.ApplicationCore.Interfaces;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace AM.Infrastructure
{
    public class GenericRepository<T> : IGenericRepository<T> where T : class
    {
        private DbContext _context;
        private DbSet<T> _dbSet;

        public GenericRepository(DbContext context)
        {
            _context = context;
            _dbSet = context.Set<T>();
        }

        public void Add(T entity)
        {
            _dbSet.Add(entity);
        }

        public void Delete(T entity)
        {
            _dbSet.Remove(entity);
        }

        public void Delete(Expression<Func<T, bool>> where)
        {
            _dbSet.RemoveRange(_dbSet.Where(where));
        }

        public T Get(Expression<Func<T, bool>> where)
        {
            return _dbSet.Find(_dbSet.Where(where))!;
        }

        public IEnumerable<T> GetAll()
        {
            return _dbSet.AsEnumerable();
        }

        public T GetById(params object[] keys)
        {
            return _dbSet.Find(keys)!;
        }

        public IEnumerable<T> GetMany(Expression<Func<T, bool>> where)
        {
            return _dbSet.Where(where).AsEnumerable();
        }

        public void Update(T entity)
        {
            _dbSet.Update(entity);
        }
    }
}
