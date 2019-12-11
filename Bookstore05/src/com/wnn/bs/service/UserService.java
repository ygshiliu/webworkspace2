package com.wnn.bs.service;

import com.wnn.bs.bean.User;

public interface UserService {
    /*用户登录功能*/
    User login(User user);

    /*注册用户*/
    boolean regist(User user);

}
