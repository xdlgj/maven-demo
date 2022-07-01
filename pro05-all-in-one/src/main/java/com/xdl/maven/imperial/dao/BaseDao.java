package com.xdl.maven.imperial.dao;

import com.xdl.maven.imperial.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 所有Dao实现类的基类
 *
 * @param <T>
 */
public class BaseDao<T> {
    // DBUtils工具包提供的数据库操作对象
    private QueryRunner runner = new QueryRunner();

    /**
     * 查询单个对象
     *
     * @param sql         执行查询的SQL语句
     * @param entityClass 实体类对应的Class对象
     * @param parameters  传给SQL语句的参数
     * @return 查询到的实体类对象
     */
    public T getSingleBean(String sql, Class<T> entityClass, Object... parameters) {
        try {
            // 获取数据库连接
            Connection connection = JDBCUtils.getConnection();
            return runner.query(connection, sql, new BeanHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
        return null;
    }

    /**
     * 通用的增删改方法， insert、delete、update操作都可以使用这个方法
     *
     * @param sql        执行的sql语句
     * @param parameters sql语句的参数
     * @return 受影响的行数
     */
    public int update(String sql, Object... parameters) {
        try {
            Connection connection = JDBCUtils.getConnection();

            int affectedRowNumber = runner.update(connection, sql, parameters);
            return affectedRowNumber;
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
        return 0;
    }

    /**
     * 查询返回多个对象的方法
     * @param sql 执行查询操作的sql语句
     * @param entityClass 实体类的Class对象
     * @param parameters sql语句的参数
     * @return 查询结果
     */
    public List<T> getBeanList(String sql, Class<T> entityClass, Object... parameters) {
        try {
            Connection connection = JDBCUtils.getConnection();
            return runner.query(connection, sql, new BeanListHandler<>(entityClass), parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            new RuntimeException(e);
        }
        return null;
    }
}
