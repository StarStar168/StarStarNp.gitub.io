package com.starstar.test;

import com.starstar.dao.UserDao;
import com.starstar.dao.impl.UserDaoImpl;
import com.starstar.pojo.User;
import org.junit.Test;


public class UserDaoImplTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("2") == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("123","123") == null){
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("用户名和密码正确");
        }
    }

    @Test
    public void saveUser() {

        System.out.println(userDao.saveUser(new User(null, "4", "2", "4")));

    }
}