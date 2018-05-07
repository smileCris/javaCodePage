package com.example.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		
		String strUserName = null;
		String strPassword = null;

		strUserName = request.getParameter("username");
		strPassword = request.getParameter("password");
		
		// 为测试方便，只要密码为123，即验证通过
		if (strUserName.length()>=6 && strPassword.equals("1234")){
			// 验证成功，进入欢迎页面
			try{
				response.sendRedirect("Welcome?username=" + strUserName);
			}catch(IOException io){
				io.printStackTrace();				
			}
		}else
		{
			// 验证失败，返回登录页面
			try{		
				response.sendRedirect("Error.jsp");
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		
	}

}
