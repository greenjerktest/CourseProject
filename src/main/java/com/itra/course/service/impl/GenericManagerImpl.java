package com.itra.course.service.impl;

import com.itra.course.dao.GenericDao;
import com.itra.course.service.GenericManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GenericManagerImpl<T> implements GenericManager<T> {

    protected GenericDao<T> dao;

    public GenericManagerImpl() {
    }

    public GenericManagerImpl(GenericDao<T> genericDao) {
        this.dao = genericDao;
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    @Override
    public List<T> search(String searchTerm) {
        if (searchTerm == null || "".equals(searchTerm.trim())) {
            return getAll();
        }

        return dao.search(searchTerm);
    }

    @Override
    public void reindex() {
        dao.reindex();
    }

    @Override
    public void reindexAll(boolean async) {
        dao.reindexAll(async);
    }

}
