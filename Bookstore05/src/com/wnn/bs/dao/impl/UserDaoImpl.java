package com.wnn.bs.dao.impl;

import com.wnn.bs.bean.User;
import com.wnn.bs.dao.BaseDao;
import com.wnn.bs.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public long saveUser(final User user) {
        String sql = "insert into bs_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User getUser(final String username) {
        String sql="select id,username,password,email from bs_user where username=?";
        return getBean(sql,username);
    }
}
