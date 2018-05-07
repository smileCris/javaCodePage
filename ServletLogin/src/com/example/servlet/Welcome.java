package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		try{
			response.setContentType("text/html;charset = GBK");
			String strUserName = null;
			
			// 参数传递的用户名，参数中有中文可能会乱码所以需要转码
			strUserName = request.getParameter("username");  
			
			// 使用给定的字符编码将参数字符串编码到 byte 序列，并将结果存储到新的 byte 数组。
            // http协议传输中默认使用的编码是iso-8859-1，所以这里getBytes()方法参数值为iso-8859-1	
			byte [] UserNameBefCode =  strUserName.getBytes("iso-8859-1");
			
			// 通过使用指定的编码，解码指定的 byte 数组，构造一个新的 String。
			// 将参数用GBK重新解码为新的字符串
			strUserName = new String(UserNameBefCode, "GBK");
						
			PrintWriter pw = response.getWriter();
			pw.write("<html>");
			pw.write("<head>");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<p><b>欢迎:</b>" + strUserName + "</p>");					
			pw.write("</body>");
			pw.write("</html>");

		} catch(IOException io){  
			io.printStackTrace();
		}
	}
}
