package com.starstar.service.impl;

import com.starstar.dao.UserDao;
import com.starstar.dao.impl.UserDaoImpl;
import com.starstar.pojo.User;
import com.starstar.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {

       return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());

    }

    @Override
    public boolean exitsUser(String username) {
        //等于空,说明没查到，取反，返回false
         return (userDao.queryUserByUsername(username) != null);
    }
}
