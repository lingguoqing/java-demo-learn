package com.ling.explame.provider;


import com.ling.explame.common.moder.User;
import com.ling.explame.common.service.UserService;

/**
 * 用户服务实现类
 */
public class UserServiceImpl implements UserService {

    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}