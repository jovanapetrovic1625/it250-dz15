package com.mycompany.methotels.dao;

import java.util.List;
import com.mycompany.methotels.entities.AbstractEntity;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JOVANA
 */
public class GenericDaoImpl<T extends AbstractEntity> implements GenericDao<T> {

    @Inject
    private Session hibernate;

    @CommitAfter
    public void saveOrUpdate(AbstractEntity obj) {
        hibernate.saveOrUpdate(obj);
    }

    @CommitAfter
    public T delete(Integer idOfObj, Class<T> entityClass) {
        @SuppressWarnings("unchecked")
        T tmpEntity = (T) hibernate.createCriteria(entityClass).add(Restrictions.eq("id", idOfObj)).uniqueResult();
        hibernate.delete(tmpEntity);
        return tmpEntity;
    }

    @CommitAfter
    public T getElementById(Integer id, Class<T> entityClass) {
        @SuppressWarnings("unchecked")
        T tmpEntity = (T) hibernate.createCriteria(entityClass).add(Restrictions.eq("id", id)).list().get(0);
        return tmpEntity;
    }

    @CommitAfter
    public List<T> loadAll(Class<T> entityClass) {
        @SuppressWarnings("unchecked")
        List<T> lista = (List<T>) hibernate.createCriteria(entityClass).list();
        return lista;
    }
}
