package com.akshu.lg;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet ("/search")
public class Log extends GenericServlet 
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		
		String uName = req.getParameter("userName");
		String pword = req.getParameter("pword");
		
		var pw = res.getWriter();
		if(uName.equals("Ash") && pword.equals("1234"))
		{
			pw.print("Success...");
		}
		else
		{
			pw.print("Failed...");
		}
	}

}
