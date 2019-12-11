package com.wnn.bs.service.impl;

import com.wnn.bs.bean.User;
import com.wnn.bs.dao.UserDao;
import com.wnn.bs.dao.impl.UserDaoImpl;
import com.wnn.bs.service.UserService;

public class UserServiceImpl implements UserService {
    
    private UserDao userDao = new UserDaoImpl();
    
    @Override
    public User login(final User user) {
        //获取数据库中的用户信息
        User dbUser = userDao.getUser(user.getUsername());
        //判断数据库中返回的用户信息与客户端输入的用户密码是否一致，一致将数据库用户返回，否则返回null
        return (dbUser != null && dbUser.getPassword().equals(user.getPassword()))?dbUser:null;
    }

    @Override
    public boolean regist(final User user) {
        long count = userDao.saveUser(user);
        return count>0?true:false;
    }
}
