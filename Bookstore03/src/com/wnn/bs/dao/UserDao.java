package com.wnn.bs.dao;

import com.wnn.bs.bean.User;

/*
* 用来操作用户信息
* */
public interface UserDao {
    //保存用户信息
    long saveUser(User user);

    //根据用户名，查询user
    User getUser(String username);
}
