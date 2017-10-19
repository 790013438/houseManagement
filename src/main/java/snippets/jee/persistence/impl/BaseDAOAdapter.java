package snippets.jee.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import snippets.jee.entity.User;
import snippets.jee.persistence.BaseDAO;

public abstract class BaseDAOAdapter<E, K extends Serializable> implements BaseDAO<E, K> {

    private Class<E> entityType;
    private String entityName;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    protected BaseDAOAdapter() {
        ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass();
        entityType = (Class<E>) pt.getActualTypeArguments()[0];
        entityName = entityType.getSimpleName();
    }

    @SuppressWarnings("unchecked")
    @Override
    public K save (E entity) {
        return (K) sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void delete (E entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public boolean deleteById (K id) {
        return sessionFactory.getCurrentSession()
            .createQuery("delete from " + entityName + " as o where o.id=:id")
            .setParameter("id", id)
            .executeUpdate() == 1;
    }

    @Override
    public void update (E entity) {
        sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public E findById (K id) {
        return sessionFactory.getCurrentSession().get(entityType, id);
    }

    @Override
    public List<E> findAll() {
        return sessionFactory.getCurrentSession()
            .createQuery("from " + entityName, entityType)
            .getResultList();
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    
}
