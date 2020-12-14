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
 * ʹ�����ݿ����ӳؼ���������������
 */
public class JDBCUtil {
    private  static DataSource dataSource;
    static {
        try {
            Properties pro = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(in);
            //  ͨ�������ഴ������Դ����
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // �ͷ���Դ
    public static void close(Statement stm, Connection conn) {
     close(null,stm,conn);
    }


    // �ͷ���Դ
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
 // ��ȡDataSource����
    public  static DataSource getDataSource(){
        return dataSource;
    }





}
