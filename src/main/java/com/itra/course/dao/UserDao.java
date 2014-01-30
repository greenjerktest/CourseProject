package com.itra.course.dao;

import com.itra.course.model.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(User user);
    public List<User> getUsers();
    public List<User> getSimpleUsers();
    public User getUserById(String id);
    public User getUserByName(String username);
}

