package com.akshu.loginregister;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllUsers
 */
public class ViewAllUsers extends HttpServlet
{
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllUsers() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void service(HttpServletRequest req , HttpServletResponse res)  
	{
		try 
		{
			ArrayList<String> viewUsers = new ViewDAO().viewUsers(con);
			if(viewUsers != null && !viewUsers.isEmpty())
			{
				req.setAttribute("viewUsers", viewUsers);
				RequestDispatcher rd = req.getRequestDispatcher("ViewSuccess.jsp");
				rd.forward(req, res);
			}
			else
			{
				req.setAttribute("viewUsers", viewUsers);
				RequestDispatcher rd = req.getRequestDispatcher("ViewFail.jsp");
				rd.forward(req, res);
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
