package com.lmd;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lmd.Common.CommonUtil;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTest {
    private static DruidDataSource dataSource;
    static {
        Properties properties = CommonUtil.loadProperties("datasource.properties");
        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CloseResource(Connection connection, Statement statement){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void CloseResource(Connection connection, Statement statement,ResultSet resultSet){
        CloseResource(connection,statement);
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //查询
    @Test
    public void toQuery() {
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = (Connection) dataSource.getPooledConnection();
            String sql = "select * from user;";
            statement  =connection.prepareStatement(sql);
            resultSet = statement.getResultSet();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String userName = resultSet.getString("userName");
                String passwd = resultSet.getString("passwd");
                String brief = resultSet.getString("brief");
                System.out.println("id为"+id+",userName为"+userName+",密码为"+passwd+"，自我介绍为"+brief);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseResource(connection,statement,resultSet);
        }

    }


    //插入
    @Test
    public void toInsert(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = (Connection) dataSource.getPooledConnection();
            String sql = "";
            statement = connection.prepareStatement(sql);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            CloseResource(connection,statement);
        }

    }

}
