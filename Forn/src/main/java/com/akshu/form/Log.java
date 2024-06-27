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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Log
 */
public class Log extends HttpServlet
{
	Connection con;

private static final long serialVersionUID = 1L;
   
/**
 * @see HttpServlet#HttpServlet()
 */
public Log()
{
    super();
}

/**
 * @see Servlet#init(ServletConfig)
 */
public void init(ServletConfig config) throws ServletException 
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
}

/**
 * @see Servlet#destroy()
 */
public void destroy() 
{
	try 
	{
		con.close();
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
}

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
	String s2 = request.getParameter("pword");
	
	var pw = response.getWriter();
	
	try 
	{
	PreparedStatement ps = con.prepareStatement("select * from userInfo where USERNAME = ? AND PASSWORD = ? ");
	ps.setString(1, s1);
	ps.setString(2, s2);
	
	ResultSet rs = ps.executeQuery();
	
	pw.print("<html><body style ='background-color : cyan; text-align : center;'>");
	
	if(rs.next())
	{
		pw.print("<h1>Welcome ..."+s1+"</h1>");
	}
	else
	{
		pw.print("<h1>Invalid UserName Password Combination.</h1>");
	}
	pw.print("<a href = 'Home.html'>Home</a></body></head>");
	pw.close();
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		pw.close();
	}
}

}
