package com.akshu.univercity;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class UnivercityRegister
 */
public class UnivercityRegister extends HttpServlet
{
	Connection con ;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnivercityRegister() 
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String uId = request.getParameter("userId");
		String pword = request.getParameter("pword");
		String email = request.getParameter("email");
		String accType = request.getParameter("accountType");
		
			try
			{
				PreparedStatement ps = con.prepareStatement("insert into univercityAccount values(?,?,?,?,?)");
				ps.setString(2, name);
				ps.setString(4, pword);
				ps.setString(3, uId);
				ps.setString(5, email);
				ps.setString(1, accType);
				int r = ps.executeUpdate();
				
				PrintWriter pw = response.getWriter();
				pw.print("<html><body>");
				if(r > 0)
				{
					if(accType.equals("Student"))
					{
						pw.print("<h1> Student Ragistration Successfull </h1>");
					}
					else
					{
						pw.print("<h1> Faculty Ragistration Successfull </h1>");
					}		
				}
				else
				{
					pw.print("<h1>Sorry...<br> Ragistratyion Failed...</h1>");
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
