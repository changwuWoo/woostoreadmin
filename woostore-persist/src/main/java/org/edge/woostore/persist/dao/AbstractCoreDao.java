package org.edge.woostore.persist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/5/7.
 */
public abstract class AbstractCoreDao<T, PK extends Serializable> implements ICoreDao<T, PK>{
    private Class<T> entityClass;
    protected SessionFactory sessionFactory;

    public AbstractCoreDao() {
        this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(PK id) {
        Assert.notNull(id, "id is required");
        return (T) getSession().get(entityClass, id);
    }

    public PK save(T entity) {
        Assert.notNull(entity, "entity is required");
        return (PK) getSession().save(entity);
    }

}
