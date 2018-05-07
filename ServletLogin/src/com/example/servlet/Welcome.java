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
			
			// �������ݵ��û����������������Ŀ��ܻ�����������Ҫת��
			strUserName = request.getParameter("username");  
			
			// ʹ�ø������ַ����뽫�����ַ������뵽 byte ���У���������洢���µ� byte ���顣
            // httpЭ�鴫����Ĭ��ʹ�õı�����iso-8859-1����������getBytes()��������ֵΪiso-8859-1	
			byte [] UserNameBefCode =  strUserName.getBytes("iso-8859-1");
			
			// ͨ��ʹ��ָ���ı��룬����ָ���� byte ���飬����һ���µ� String��
			// ��������GBK���½���Ϊ�µ��ַ���
			strUserName = new String(UserNameBefCode, "GBK");
						
			PrintWriter pw = response.getWriter();
			pw.write("<html>");
			pw.write("<head>");
			pw.write("</head>");
			pw.write("<body>");
			pw.write("<p><b>��ӭ:</b>" + strUserName + "</p>");					
			pw.write("</body>");
			pw.write("</html>");

		} catch(IOException io){  
			io.printStackTrace();
		}
	}
}
