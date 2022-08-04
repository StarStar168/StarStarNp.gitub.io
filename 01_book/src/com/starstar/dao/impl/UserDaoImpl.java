package com.starstar.dao.impl;

import com.starstar.dao.UserDao;
import com.starstar.pojo.User;

public class UserDaoImpl extends BasicDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username=? ";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(`username`,`password`,`email`) VALUES(?,?,?)";

        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
