package com.akshu.form;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Reg
 */
public class Reg extends HttpServlet
{
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##Ash" , "akshu");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		String s1 = request.getParameter("userName");
		String s2 = request.getParameter("fName");
		String s3 = request.getParameter("lName");
		String s4 = request.getParameter("pword");
		
		var pw = response.getWriter();
		
		try 
		{
		PreparedStatement ps = con.prepareStatement("insert into userinfo values(?,?,?,?)");
		ps.setString(1, s1);
		ps.setString(2, s2);
		ps.setString(3, s3);
		ps.setString(4, s4);
		int r = ps.executeUpdate();
		
		pw.print("<html><body style ='background-color : cyan; text-align : center;'>");
		
		if(r > 0)
		{
			pw.print("<h1>User Registration Successfull.....</h1>");
		}
		else
		{
			pw.print("<h1>Sorry...<br> Registration Failed.....</h1>");
		}
		pw.print("<a href = 'index.html'>Home</a></body></head>");
		pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			pw.close();
		}
	}
}
