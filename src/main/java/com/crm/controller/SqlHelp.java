package com.crm.controller;

import javax.swing.*;
import java.sql.*;

public class SqlHelp {
	private String driverName="com.mysql.cj.jdbc.Driver";
	private String dbURL="jdbc:mysql://localhost:3306/crm?serverTimezone=UTC";
	private String userName="root";
	private String userPwd="root";
	private static Connection connection = null;
	private static SqlHelp sqlHelp = null;
	private PreparedStatement preparedStatement = null;
	//加载驱动
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlHelp getInitJdbcUtil() {
		if (sqlHelp == null) {
			//线程加锁
			synchronized (SqlHelp.class) {
				if (sqlHelp == null) {
					//懒汉式加载
					sqlHelp = new SqlHelp();
				}
			}
		}
		return sqlHelp;
	}
	//连接数据库
	public Connection getConnection() {

		try {
			connection = DriverManager.getConnection(dbURL, userName, userPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	
	public ResultSet query(String sql){
		connection=getConnection();
		ResultSet rest = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			Statement smt=getConnection().createStatement();
			rest=smt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return rest;
	}
	
	public boolean cudexecute(String sql){
		Connection conn=null;
		int i=0;
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(dbURL,userName,userPwd);
			Statement smt=conn.createStatement();
			i=smt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		if (i!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void Close(Connection conn){  //数据库连接
		try {
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void Close(ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Close(PreparedStatement pst){
		try {
			if (pst!=null) {
				pst.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Close(Statement stmt){
		try {
			if (stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
