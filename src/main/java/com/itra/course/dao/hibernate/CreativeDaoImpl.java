package com.itra.course.dao.hibernate;

import com.itra.course.dao.CreativeDao;
import com.itra.course.model.Creative;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 19:56
 */

@Repository
public class CreativeDaoImpl extends GenericDaoImpl<Creative, Long> implements CreativeDao {

    public CreativeDaoImpl() {
        super(Creative.class);
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Creative> getAll() {
        List<Creative> creativeList = sessionFactory.getCurrentSession().createCriteria(Creative.class).list();
        return new ArrayList<>(new HashSet<>(creativeList));
    }

    @Override
    public long addCreative(Creative creative) {
        sessionFactory.getCurrentSession().save(creative);
        return (long) sessionFactory.getCurrentSession().createCriteria(Creative.class)
                .setProjection(Projections.max("id")).uniqueResult();
    }
}
