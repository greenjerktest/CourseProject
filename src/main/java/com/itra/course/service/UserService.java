package com.itra.course.service;

import com.itra.course.form.RegisterForm;
import com.itra.course.form.UserForm;
import com.itra.course.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService extends GenericManager<User, Long> {

    public void addUser(RegisterForm form);
    public void blockUser(String username);
    public List<User> getSimpleUsers();
    public User getUserByName(String username);
    public void setAvatar(User user, MultipartFile file) throws IOException;
    public byte[] getCurrentAvatar(User user) throws IOException;
}
