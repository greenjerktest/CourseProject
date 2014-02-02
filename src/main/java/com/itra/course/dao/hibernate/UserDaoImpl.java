package com.itra.course.dao.hibernate;

import java.util.List;

import com.itra.course.dao.GenericDao;
import com.itra.course.dao.UserDao;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itra.course.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
        super(User.class);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> getSimpleUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("authority", "ROLE_USER")).list();
    }


    @Transactional
    public User getUserByName(String username) {
        User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();
        return  user;
    }
}
