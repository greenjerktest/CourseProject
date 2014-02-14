package com.itra.course.service.impl;

import com.itra.course.dao.UserDao;
import com.itra.course.form.RegisterForm;
import com.itra.course.model.User;
import com.itra.course.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

//import org.springframework.security.core.userdetails.User;

@Transactional
@Service
public class UserServiceImpl extends GenericManagerImpl<User, Long> implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl (UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    public void blockUser(String username) {
        User user = userDao.getUserByName(username);
        user.setEnabled(!user.isEnabled());
        userDao.save(user);
    }

    public void addUser(RegisterForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setEnabled(true);
        user.setAuthority("ROLE_USER");
        userDao.save(user);
    }

    public List<User> getSimpleUsers() {
        return userDao.getSimpleUsers();
    }

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    public void setAvatar(User user, MultipartFile avatar) throws IOException {
            user.setAvatar(IOUtils.toByteArray(avatar.getInputStream()));
            userDao.save(user);

    }

    public byte[] getCurrentAvatar(User user) throws IOException {
        byte[] avatar = user.getAvatar();
        if (avatar == null) {
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("image/default-avatar.png");
            return IOUtils.toByteArray(in);
        }
        return avatar;
    }
}
