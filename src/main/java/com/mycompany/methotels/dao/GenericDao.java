package com.mycompany.methotels.dao;

import com.mycompany.methotels.entities.AbstractEntity;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import java.util.List;

/**
 *
 * @author JOVANA
 */
public interface GenericDao<T extends AbstractEntity> {

    @CommitAfter
    public void saveOrUpdate(T obj);

    @CommitAfter
    public T delete(Integer idOfObj, Class<T> entityClass);

    @CommitAfter
    public List<T> loadAll(Class<T> entityClass);

    @CommitAfter
    public T getElementById(Integer id, Class<T> entityClass);
}
