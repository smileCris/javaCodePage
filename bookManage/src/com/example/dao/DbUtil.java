package com.example.dao;
import java.sql.*;
import user.User;

import user.User;

public class DbUtil {
	
	private static final String URL = "jdbc:mysql://localhost:3306/test";	
	private static final  String USER = "root";
	private static final String PASSWORD = "password";
	
	protected static Statement s = null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	
	public static synchronized Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		}catch (Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static int executeUpdate(String sql){
		int result = 0;
		try{
			s = getConnection().createStatement();
			result = s.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static ResultSet executeQuery(String sql){
		try{
			s = getConnection().createStatement();
			rs = s.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public static PreparedStatement executePreparedStatement(String sql){
		PreparedStatement ps = null;
		try{
			ps = getConnection().prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ps;
	}
	
	public static void rollback(){
		try{
			getConnection().rollback();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(){
		try{
			if(rs!=null)
				rs.close();
			if(s!=null)
				s.close();
			if(conn!=null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
