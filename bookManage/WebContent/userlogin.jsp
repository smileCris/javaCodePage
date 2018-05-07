<%@ page language="java"  import="java.util.*,com.example.dao.DbUtil,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'useradmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <%
	    request.setCharacterEncoding("utf-8");
	    String user_id=request.getParameter("user_id");
	    String user_name=request.getParameter("user_name");
	    String tel=request.getParameter("tel");
	    String password=request.getParameter("password");
    	
    	String sql = "INSERT INTO user(user_id,user_name,tel,password) VALUES(?,?,?,?)";

    	
    	int result = 0;
    	try{
    		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
    		ps.setString(1,user_id);
    		ps.setString(2, user_name);
    		ps.setString(3,tel);
    		ps.setString(4,password);
    		result = ps.executeUpdate();
    		ps.close();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	request.setCharacterEncoding("utf-8");
     %>
  用户注册登录系统
     <form action="userresult.jsp" method="post">
                  用户名：<input type="text" name="user_name"><br>
                  密码：<input type="text" name="tel"><br>
     <input type="submit" value="登录">
     <a href="useradmin.jsp">注册</a>
    </form>
  </body>
</html>
