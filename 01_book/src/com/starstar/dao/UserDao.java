package com.starstar.dao;

import com.starstar.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查找用户信息
     * @param username 用户名
     * @return 如果返回null，说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查找用户信息
     * @param username 用户名
     * @param password 密码
     * @return 如果返回null，说明密码或用户名错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示保存失败，否则返回成功行数
     */
    public int saveUser(User user);
}
