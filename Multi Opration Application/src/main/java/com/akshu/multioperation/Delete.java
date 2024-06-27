package com.akshu.multioperation;

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
import java.sql.SQLException;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

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
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		UserBEAN ub = new UserBEAN();
		
		ub.setPhoneNumber(req.getParameter("phoneNumber"));
		
		boolean  r = new DeleteDAO().delete(ub, con);
		
		PrintWriter pw = res.getWriter();
		
		pw.print("<html> <body style = 'background-color : yellow; color : RED '>");
		if(r)
		{
			pw.print("<h1> Record Deleted SuccessFully...</h1>");
		}
		else
		{
			pw.print("<h1>  Deletion Failed......</h1>");
			pw.print("Phone Number is Not Avialable...");
		}
		pw.print("<a href='index.html'> Home</a>");
		pw.print("</body> </html>");
		pw.close();
		
	}
}
