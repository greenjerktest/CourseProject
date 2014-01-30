package com.itra.course.dao.hibernate;

import com.itra.course.dao.CommentDao;
import com.itra.course.model.Comment;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User: Greenjerk
 * Date: 27.01.14
 * Time: 11:40
 */

@Repository
public class CommentDaoImpl  extends GenericDaoImpl<Comment> implements CommentDao {

    public CommentDaoImpl() {
        super(Comment.class);
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addComment(Comment comment) {
        sessionFactory.getCurrentSession().save(comment);
    }

    @Override
    public void removeComment(long id) {
        String hql = "delete from Comment c where c.id= :id";
        sessionFactory.getCurrentSession()
                .createQuery(hql).setLong("id", id).executeUpdate();
    }

}
