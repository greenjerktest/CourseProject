package com.itra.course.dao;

import org.hibernate.search.SearchException;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface GenericDao<T> {

    List<T> getAll();

    List<T> search(String searchTerm) throws SearchException;

    void reindex();

    void reindexAll(boolean async);

    List<T> queryHql(String hql);

}