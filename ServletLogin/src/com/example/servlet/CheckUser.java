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
		
		// Ϊ���Է��㣬ֻҪ����Ϊ123������֤ͨ��
		if (strUserName.length()>=6 && strPassword.equals("1234")){
			// ��֤�ɹ������뻶ӭҳ��
			try{
				response.sendRedirect("Welcome?username=" + strUserName);
			}catch(IOException io){
				io.printStackTrace();				
			}
		}else
		{
			// ��֤ʧ�ܣ����ص�¼ҳ��
			try{		
				response.sendRedirect("Error.jsp");
			}catch(IOException io){
				io.printStackTrace();
			}
		}
		
	}

}
