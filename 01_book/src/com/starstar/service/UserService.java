package com.starstar.service;

import com.starstar.pojo.User;

public interface UserService {

    /**
     * 注册用户
     * @param user 用户信息
     */
    public void registUser(User user);

    /**
     * 用户登录
     * @param user 返回空说明登陆失败，有值说明登陆成功
     */
    public User login(User user);

    /**
     * 查询用户是否存在
     * @param username 返回true说明存在，返回false说明不存在
     */
    public boolean exitsUser(String username);
}
