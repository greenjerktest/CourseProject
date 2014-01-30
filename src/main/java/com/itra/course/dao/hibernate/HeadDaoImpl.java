package com.itra.course.dao.hibernate;

import com.itra.course.dao.HeadDao;
import com.itra.course.model.Head;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User: Greenjerk
 * Date: 28.01.14
 * Time: 11:35
 */

@Repository
public class HeadDaoImpl extends GenericDaoImpl<Head>  implements HeadDao {

    public HeadDaoImpl() {
        super(Head.class);
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addHead(Head head) {
        sessionFactory.getCurrentSession().save(head);
    }
}
