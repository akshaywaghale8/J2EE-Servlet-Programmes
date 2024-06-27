package com.akshu.loginregister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet 
{
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	 public void init(ServletConfig config) throws ServletException 
	{
		ServletContext scont = config.getServletContext();
		
		String s1 = scont.getInitParameter("driver");
		String s2 = scont.getInitParameter("databaseUrl");
		String s3 = scont.getInitParameter("userName");
		String s4 = scont.getInitParameter("pword");
		
		try
		{
			Class.forName(s1);
			con = DriverManager.getConnection(s2,s3,s4);
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
		UserBean ub = new UserBean();
		
		ub.setUserName(request.getParameter("username"));
		ub.setPassword(request.getParameter("password"));
		ub.setEmail(request.getParameter("email"));
		ub.setPhoneNumber(request.getParameter("phoneNumber"))	;
		ub.setAddress(request.getParameter("address"));
		ub.setState(request.getParameter("state"));
		ub.setCountry(request.getParameter("country"));
		
		try
		{
			int rs = new RegDAO().insert(ub, con);
		
			if(rs > 0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("RegSuccess.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("RegFail.jsp");
				rd.forward(request, response);	
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}	
	}
}
