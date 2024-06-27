package com.akshu.univercity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnivercityLogin
 */
public class UnivercityLogin extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnivercityLogin() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Connection con ;
	public void init(ServletConfig config) throws ServletException
	{
		
		 ServletContext scont = config.getServletContext();
		 String s1 = scont.getInitParameter("databaseUrl");
		 String s2 = scont.getInitParameter("userName");
		 String s3 = scont.getInitParameter("pword");
		 String driver = scont.getInitParameter("driver");
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(s1,s2,s3);
		} 
		catch (SQLException | ClassNotFoundException e) 
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
	{
		
		String uId = request.getParameter("userId");
		String pword = request.getParameter("pword");
	
			try
			{
				PreparedStatement ps = con.prepareStatement("select * from univercityAccount where  USERID = ?  AND  PASSWORD = ?");
				ps.setString(1, uId);
				ps.setString(2, pword);

				ResultSet rs = ps.executeQuery();
				
				PrintWriter pw = response.getWriter();
				pw.print("<html><body>");
				if(rs.next())
				{
					pw.print("<h1>Welcome to Faculty Section " +rs.getString("Name")+"</h1>");
				}
				else
				{
					pw.print("<h1>Invalid UserId And Password Combination</h1>");
				}
				pw.print("<a href='index.html'>Home</a>");
				pw.print("</body></html>");
				pw.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}

