package com.starstar.test;

import com.starstar.pojo.User;
import com.starstar.service.UserService;
import com.starstar.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"13","321", "123"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"13","321",null)));
    }

    @Test
    public void exitsUser() {
        System.out.println(userService.exitsUser("13"));

    }
}