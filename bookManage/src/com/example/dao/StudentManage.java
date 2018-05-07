package com.example.dao;
import java.sql.*;
import user.User;
public class StudentManage {
	
	public boolean add(User s){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pt = null;
		conn = com.example.dao.DbUtil.getConnection();
		String sql = "INSERT INtO user(user_id,user_name,tel) VALUES(?,?,?)";
		try{
			pt = conn.prepareStatement(sql);
    		pt.setString(1,s.getUser_id());
    		pt.setString(2, s.getUser_name());
    		pt.setString(3,s.getTel());
    		int row = pt.executeUpdate();
    		if(row > 0){
    			flag = true;
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			com.example.dao.DbUtil.close();
		}
		return flag;
		
	}
	public boolean checkLogin(String name,String password) {
		boolean flag = false;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from user where name="+name;
		conn = com.example.dao.DbUtil.getConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("password").equals(password)){
					flag = true;
				}
			} 
		}catch (SQLException e){
			e.printStackTrace();
		} finally{
			com.example.dao.DbUtil.close();
		}
		return flag;
	}
}
