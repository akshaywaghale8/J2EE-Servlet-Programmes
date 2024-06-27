package com.akshu.personalInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PersonalDetaile
 */
public class PersonalDetaile extends HttpServlet 
{
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalDetaile() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "C##ash" , "akshu");
		} 
		catch (ClassNotFoundException | SQLException e) 
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
		String s1 = request.getParameter("fname");
		int s2 = Integer.parseInt(request.getParameter("age"));
		long s3 = Long.parseLong(request.getParameter("mNumber"));
		String s4 = request.getParameter("gender");
		String[] s5 = request.getParameterValues("hobbies");
		PrintWriter pw = response.getWriter();		

		try  
		{
			PreparedStatement ps = con.prepareStatement("insert into personalDetails values (?,?,?,?,?)");
			ps.setString(1, s1);
			ps.setInt(2, s2);
			ps.setLong(3, s3);
			ps.setString(4, s4);
			ps.setString(5, Arrays.toString(s5));
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
		catch (SQLException e) 
		{
			e.printStackTrace();
			pw.close();
		}	
	}
}
