package com.crm.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crm.controller.SqlHelp;
import com.crm.controller.UserDao;
import com.crm.model.User_Model;

public class UserDaoImp implements UserDao {

    SqlHelp sql1=new SqlHelp();
    public int CheckUser(String id,String password,String usertype) throws SQLException {
        String sql="select * from login where usertype="+usertype+"";
        ResultSet rest=sql1.query(sql);

        try {
            while (rest.next()) {
                if (rest.getString(1).equals(id)) {
                    if (rest.getString("userpwd").equals(password)) {     //如果密码匹配，则返回0
                        return 0;
                    }
                    else {             //如果密码不匹配，则返回1
                        return 1;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;            //如果未找到此ID，则返回-1
    }

    public User_Model selectUser(String usertype,String id){
        String sql="select * from login where usertype="+usertype+"";
        ResultSet rs=new SqlHelp().query(sql);
        try {
            while (rs.next()) {
                if (rs.getString(1).equals(id)) {
                    return new User_Model(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int update(Connection con,User_Model user_model)throws Exception{
        String sql="update user set eid=?,uname=?,phone=?,address=?,create=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user_model.getEid());
        pstmt.setString(2, user_model.getUname());
        pstmt.setString(3, user_model.getPhone());
        pstmt.setString(4, user_model.getAddress());
        pstmt.setString(5, user_model.getCredit());
        pstmt.setString(6,user_model.getUid());
        return pstmt.executeUpdate();
    }

    @Override
    public boolean addUser(User_Model user) throws SQLException {
        String sql="insert login values('"+user.getUid()+"','"+user.getPwd()+"',1)";
        String sql2 = "insert user values(0,'"+user.getEid()+"','"+user.getUname()+"','"+user.getPhone()+"','"+user.getAddress()+"','"+user.getCredit()+"')";
        System.out.println(sql);
        if (sql1.cudexecute(sql)&&sql1.cudexecute(sql2))
            return true;
        else
            return false;
    }

    @Override
    public int delUser(Connection con,User_Model user) throws SQLException {

        String sql="delete from user where id=?";
        String sql2="delete from login where username=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1, user.getUid());
        return pstmt.executeUpdate();
    }

    private List<User_Model> convert(ResultSet rs) throws SQLException {
        List<User_Model> list = new ArrayList<>();
        while (rs.next()) {
            User_Model user = User_Model.builder()
                    .uid(rs.getString("uid"))
                    .eid(rs.getString("eid"))
                    .uname(rs.getString("uname"))
                    .phone(rs.getString("phone"))
                    .address(rs.getString("address"))
                    .credit(rs.getString("credit"))
                    .build();
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User_Model> selectAll() throws SQLException {
        SqlHelp sqlHelp = SqlHelp.getInitJdbcUtil();
        Connection con =sqlHelp.getConnection();
        String sql ="Select * from user";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<User_Model> usList =convert(rs);
        rs.close();
        pstmt.close();
        sqlHelp.Close();

        return usList;
    }

    @Override
    public List<User_Model> selectUid() throws SQLException {
        return null;
    }

    @Override
    public List<User_Model> selectUname() throws SQLException {
        return null;
    }
}