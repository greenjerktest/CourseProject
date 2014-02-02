package com.itra.course.dao;

import com.itra.course.model.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Long> {

    public List<User> getSimpleUsers();
    public User getUserByName(String username);
}

