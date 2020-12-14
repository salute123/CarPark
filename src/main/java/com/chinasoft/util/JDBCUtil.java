package com.chinasoft.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 使用数据库连接池技术来制作工具类
 */
public class JDBCUtil {
    private  static DataSource dataSource;
    static {
        try {
            Properties pro = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            //  通过工厂类创建数据源对象
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 释放资源
    public static void close(Statement stm, Connection conn) {
     close(null,stm,conn);
    }


    // 释放资源
    public static void close(ResultSet rs, Statement stm, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
 // 获取DataSource方法
    public  static DataSource getDataSource(){
        return dataSource;
    }





}
