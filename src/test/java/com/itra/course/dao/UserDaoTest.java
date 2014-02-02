package com.itra.course.dao;

import com.itra.course.BaseTestCase;
import com.itra.course.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoTest extends BaseTestCase {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("test");
        user.setEmail("a4test@gmail.com");
        user.setPassword("qwerty");
        userDao.save(user);

    }

    @Test
    public void testReindex() {
        userDao.reindexAll(false);
    }

}
