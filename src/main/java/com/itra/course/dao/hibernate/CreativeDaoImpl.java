package com.itra.course.dao.hibernate;

import com.itra.course.dao.CreativeDao;
import com.itra.course.model.Creative;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

/**
 * User: Greenjerk
 * Date: 25.01.14
 * Time: 19:56
 */

@Repository
public class CreativeDaoImpl extends GenericDaoImpl<Creative> implements CreativeDao {

    public CreativeDaoImpl() {
        super(Creative.class);
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public HashSet<Creative> getCreatives() {
        List<Creative> creativeList = sessionFactory.getCurrentSession().createCriteria(Creative.class).list();
        return new HashSet<Creative>(creativeList);
    }

    @Override
    public Creative getCreative(long id) {
        return (Creative) sessionFactory.getCurrentSession()
                .createCriteria(Creative.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public long addCreative(Creative creative) {
        sessionFactory.getCurrentSession().save(creative);
        return (long) sessionFactory.getCurrentSession().createCriteria(Creative.class)
                .setProjection(Projections.max("id")).uniqueResult();
    }
}
