<%@ page language="java" import="java.util.*,com.example.dao.DbUtil,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookresult.jsp' starting page</title>
    
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
	    String book_name=request.getParameter("book_name");
	    String book_id=request.getParameter("book_id");
	    String book_time=request.getParameter("book_time");
    	
    	String sql = "INSERT INTO book(book_id,book_name,book_time) VALUES(?,?,?)";

    	
    	int result = 0;
    	try{
    		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
    		ps.setString(1,book_id);
    		ps.setString(2, book_name);
    		ps.setString(3,book_time);
    		result = ps.executeUpdate();
    		ps.close();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
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

   <jsp:useBean id="book" class="book.Book" scope="request" />
    <jsp:setProperty property="book_name" name="book" value="<%=book_name%>"/>
    <jsp:setProperty property="book_id" name="book" value="<%=book_id%>"/>
    <jsp:setProperty property="book_time" name="book" value="<%=book_time%>"/>
          书名：<jsp:getProperty property="book_name" name="book"/><br>
          书号：<jsp:getProperty property="book_id" name="book"/><br>
          日期：<jsp:getProperty property="book_time" name="book" /><br>
  </body>
</html>
