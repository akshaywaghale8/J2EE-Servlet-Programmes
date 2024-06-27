package com.akshu.multioperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
    
    Connection con;
    
	public void init(ServletConfig config) throws ServletException 
	{
		ServletContext scont = config.getServletContext();
		
		String s1 = scont.getInitParameter("driver");
		String s2 = scont.getInitParameter("driverUrl");
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
		UserBEAN ub = new UserBEAN();
		
		ub.setUserName(request.getParameter("userName"));
		ub.setPassword(request.getParameter("password"));
		
		boolean login = new LoginDAO().login(ub, con);
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<html> <body style = 'background-color : 'yellow' ; color : 'RED' ; text-align : 'center' ; '>");
		if(login)
		{
			pw.print("<h1> Login Successful......<br>Welcome "+ub.getUserName()+"</h1>");
		}
		else
		{
			pw.print("<h1> Login Failed......</h1>");
		}
		pw.print("<a href='index.html'> Home</a>");
		pw.print("</body> </html>");
		pw.close();
		
	}

}
