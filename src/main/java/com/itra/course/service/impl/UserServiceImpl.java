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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void removeUser(String username) {
        userDao.removeUser(userDao.getUserByName(username));
    }

    public void blockUser(String username) {
        User user = userDao.getUserByName(username);
        user.setEnabled(!user.isEnabled());
        userDao.updateUser(user);
    }

    public void addUser(RegisterForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setEnabled(true);
        user.setAuthority("ROLE_USER");
        userDao.addUser(user);
    }

    public long updateUser(User user) {
        userDao.updateUser(user);
        return user.getId();
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public List<User> getSimpleUsers() {
        return userDao.getSimpleUsers();
    }

    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    public String getAvatarRef(String username) {
        return userDao.getUserByName(username).getAvatarRef();
    }

    public void setAvatarRef(User user, MultipartFile avatar) throws IOException {
        String path = System.getProperty("user.home") + "/avatars/"
                + user.getUsername();
        File file = new File(path);
        if (file.mkdirs() || file.exists()) {
            File f = new File(path + "/" + avatar.getOriginalFilename());
            OutputStream output = new FileOutputStream(f);
            output.write(IOUtils.toByteArray(avatar.getInputStream()));
            output.flush();
            output.close();
            user.setAvatarRef(f.getAbsolutePath());
            userDao.updateUser(user);
        }
    }

    public byte[] getCurrentAvatar(User user) throws IOException {

        if (user.getAvatarRef() == null) {
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("image/default-avatar.png");

            return IOUtils.toByteArray(in);
        }

        InputStream in = new FileInputStream(user.getAvatarRef());
        return IOUtils.toByteArray(in);
    }
}
