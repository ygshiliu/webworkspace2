package com.wnn.bs.test;

import com.wnn.bs.bean.User;
import com.wnn.bs.dao.UserDao;
import com.wnn.bs.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDaoImpl();
    }

    @Test
    public void saveUser() {
        User user = new User(null, "hehe", "123456", "hehe@163.com");
        userDao.saveUser(user);
    }

    @Test
    public void getUser() {
        User hehe = userDao.getUser("hehe");
        System.out.println(hehe);
    }
}