package org.woo.persist.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * Created by Administrator on 2017/4/12.
 */
@Repository
public abstract class AbstractCoreDao<T, PK extends Serializable> implements ICoreDao<T, PK> {
    private Class<T> entityClass;
    @Resource
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	public AbstractCoreDao() {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    @Resource
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return getSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        return (PK) getSession().save(entity);
    }

    @Override
    public int deleteByPrimaryKey(String hql, Map<String, Object> map) {
        return 0;
    }

    @SuppressWarnings("unchecked")
	@Override
    public int getCount(String hql) {
        Query<T> q = getSession().createQuery(hql);
        return Integer.parseInt(q.list().get(0).toString());
    }

    @Override
    public int insert(String sql, Map<String, Object> map) {
        return sqlQueryBuilder(sql, map).executeUpdate();
    }

    @Override
    public Collection<T> queryForPage(int offset, int length, String hql, Map<String, Object> map) {
        Collection<T> result = null;
        Query<T> query = hqlQueryBuilder(hql, map);
        query.setFirstResult(offset);
        query.setMaxResults(length);
        result = query.list();
        return result;
    }

    @Override
    public boolean isExistByName(String hql, Map<String, Object> map) {
        T t = (T) hqlQueryBuilder(hql, map).uniqueResult();
        if (t != null) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
	@Override
    public Query<T> hqlQueryBuilder(String hql, Map<String, Object> map) {
        Query<T> query;
        try {
            query = this.getSession().createQuery(hql);
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                entry.getValue();
                entry.getKey();
            }
            Iterator<String> it = map.keySet().iterator();
            int index = 0;
            while (it.hasNext()) {
                Object key = it.next();
                query.setParameter(index, map.get(key));
                index++;
            }
        } catch (RuntimeException re) {
            throw re;
        } finally {
        }
        return query;
    }

    @SuppressWarnings("unchecked")
	@Override
    public Query<T> sqlQueryBuilder(String sql, Map<String, Object> map) {
        Query<T> query;
        try {
            query = this.getSession().createNativeQuery(sql);
            Iterator<String> it = map.keySet().iterator();
            int index = 0;
            while (it.hasNext()) {
                Object key = it.next();
                query.setParameter(index, map.get(key));
                index++;
            }
        } catch (RuntimeException re) {
            throw re;
        } finally {
        }
        return query;
    }

    @SuppressWarnings("unchecked")
	@Override
    public Collection<T> selectAll(String hql, Map<String, Object> map) {
        Collection<T> tCollection = null;
        tCollection = getSession().createQuery(hql).list();
        return tCollection;
    }

    @Override
    public Collection<T> selectByFiled(String hql, Map<String, Object> map) {
        Collection<T> tCollection = null;
        tCollection = hqlQueryBuilder(hql, map).list();
        return tCollection;
    }

    public T selectByUniqueFiled(String hql, Map<String, Object> map) {
        return (T) hqlQueryBuilder(hql, map).uniqueResult();
    }

    @Override
    public int updateByPrimaryKey(String sql, Map<String, Object> map) {
        int resultFlag = sqlQueryBuilder(sql, map).executeUpdate();
        return resultFlag;
    }

    @Override
    public String getSeq(String sql) {
        return getSession().createNativeQuery(sql).uniqueResult().toString();
    }
}
