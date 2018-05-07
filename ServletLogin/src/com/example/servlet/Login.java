package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			response.setContentType("text/html;charset = GBK");
			request.setCharacterEncoding("GBK");
			PrintWriter pw = response.getWriter();
			pw.write("<html>");
			pw.write("<head>");
			pw.write("<meta http-equiv=\"content-type\" content = \"text/html; charset=GBK\">");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<h1>欢迎登录</h1>");
			
			pw.write("<form name = \"login\" action = \"CheckUser\" method = \"post\">");
			pw.write("用户名<input type = \"text\" name = \"username\" value = \"\"/><br/><br/>");
			pw.write("密&nbsp码<input type = \"password\" name = \"password\" value = \"\"/><br/><br/>");
			pw.write("<input type = \"submit\" name = \"submit\" value = \"提交\"/>");
			pw.write("</form>");	
			
			pw.write("</body>");
			pw.write("</html>");

		} catch(IOException io){  
			io.printStackTrace();
		}
		
	
	}
}
