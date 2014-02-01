package com.itra.course.dao.hibernate;

import com.itra.course.dao.TagDao;
import com.itra.course.model.Tag;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User: Greenjerk
 * Date: 31.01.14
 * Time: 12:37
 */

@Repository
public class TagDaoImpl extends GenericDaoImpl<Tag, Long> implements TagDao {

    @Autowired
    private SessionFactory sessionFactory;

    public TagDaoImpl() {
        super(Tag.class);
    }

    @Override
    public Tag getTagByName(String tagName) {
        return (Tag) sessionFactory.getCurrentSession().createCriteria(Tag.class)
                .add(Restrictions.eq("tagName", tagName)).uniqueResult();
    }
}
