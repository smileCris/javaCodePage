<%@ page language="java" import="java.util.*,com.example.dao.DbUtil,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userresult.jsp' starting page</title>
    
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
    <table  width="80%"  border="1">
  <tr>
    <th>ID</th>
    <th>书名</th>
    <th>借阅时间</th>
    <th>删除</th>
 </tr>
  <%
  request.setCharacterEncoding("utf-8");
  String user_id=request.getParameter("user_id");
  String user_name=request.getParameter("user_name");
  String tel=request.getParameter("tel");
	int result = 0;
    	if(result>0){
    		String sqlSearch = "SELECT * FROM book";
    		ResultSet rs = null;
    		rs = DbUtil.executeQuery(sqlSearch);
    		StringBuffer sb = new StringBuffer();
    		try{
    			while(rs.next()){
         %>
     <tr>
      <td>
      <%=rs.getInt(1)%>
      </td>
      <td>
       <a href="prepareupdate?ID=<%=rs.getInt("book_id")%>" target="_blank"><%=rs.getString(2)%></a>
      </td>
      <td>
       <%=rs.getString(3)%>
      </td>
      <td>
      <a href="delete?ID=<%=rs.getInt("book_id")%>" target="_blank">删除</a>
      </td>
     </tr>
     <%
    			}
    			DbUtil.close();
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    	}
    	request.setCharacterEncoding("utf-8");
     %>
</table>
    <jsp:useBean id="user" class="user.User" scope="request" />
    <jsp:setProperty property="user_id" name="user" value="<%=user_id%>"/>
    <jsp:setProperty property="user_name" name="user" value="<%=user_name%>"/>
    <jsp:setProperty property="tel" name="user" value="<%=tel%>"/>
          用户ID：<jsp:getProperty property="user_id" name="user"/><br>
          用户姓名：<jsp:getProperty property="user_name" name="user"/><br>
          联系方式：<jsp:getProperty property="tel" name="user" /><br>
    <%
	   // 重定向到新地址
	   String site = new String("bookAdmin.jsp");
	   response.setStatus(response.SC_MOVED_TEMPORARILY);
	   response.setHeader("Location", site); 
	%>
  </body>
</html>
