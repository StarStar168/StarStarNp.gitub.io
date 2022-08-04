package com.starstar.dao.impl;

import com.starstar.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BasicDao {

    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();


    /**
     * 执行增删改操作
     * @param sql   语句
     * @param args  参数
     * @return      返回-1表示失败，否则返回成功行数
     */
    public int update(String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询操作返回一个javaBean的sql语句
     * type  返回的对象类型
     * sql   执行的sql语句
     * args  sql对应的参数值
     * <T>   返回的泛型的类型
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询操作返回多个javaBean的sql语句
     * type  返回的对象类型
     * sql   执行的sql语句
     * args  sql对应的参数值
     * <T>   返回的泛型的类型
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args) {
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }


    /**
     * 单行单列的sql语句
     * sql   执行的sql语句
     * args  sql对应的参数值
     */
    public Object queryForSingleValue(String sql, Object ... args){
        Connection connection = JdbcUtils.getConnection();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
