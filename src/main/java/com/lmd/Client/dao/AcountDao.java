package com.lmd.Client.dao;

import com.lmd.Client.entity.User;

import java.sql.*;

public class AcountDao extends BasedDao {
    // 用户注册 insert
    public boolean userReg(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = getConnection();
            String sql = "insert into user(username,passwd,brief) values (?,?,?)";
            statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,"username");
            statement.setString(2,"passwd");
            statement.setString(3,"brief");
            int rows = statement.executeUpdate();
            if (rows == 1)
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeResources(connection,statement);
        }
        return false;
    }

    //用户登录
    public User userLogin(String userName,String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            String sql = "select * from user where username=? and passwd=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,userName);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = getUser(resultSet);
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeResources(connection,statement,resultSet);
        }
        return null;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPasswd(resultSet.getString("password"));
        user.setBrief(resultSet.getString("brief"));
        return user;
    }
}
