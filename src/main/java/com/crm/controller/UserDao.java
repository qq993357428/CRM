package com.crm.controller;

import com.crm.model.User_Model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    /*
    * 形参：用户信息
    * 功能：添加用户
    * 返回值：添加成功 返回true
    */
    boolean addUser(User_Model user) throws SQLException;

    /*
    * 形参：用户信息
    * 功能:删除用户
    * 返回值：删除成功返回1
    * */
    int delUser(Connection con,User_Model user) throws SQLException;
    /*
    * 查询所有用户（视图对象
    * @return 用户生试图列表数据
    * @throws SQLException 异常
    * */
    List<User_Model> selectAll() throws SQLException;
    /*
     * 根据uid查询所有用户（视图对象
     * @return 用户试图列表数据
     * @throws SQLException 异常
     * */
    List<User_Model> selectUid() throws SQLException;
    /*
     * 根据用户名查询所有用户（视图对象
     * @return 用户试图列表数据
     * @throws SQLException 异常
     * */
    List<User_Model> selectUname() throws SQLException;

}
