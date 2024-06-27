package com.akshu.text;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/table")

public class P1 extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		
		try(pw)
		{
			pw.println("<html> <body style = 'background-color : yellow'>");
			pw.println("<h1 style = 'text-align : center'>This are Tables</h1>");
			for(int i = 2 ; i <= 20 ; i++)
			{
				for(int j = 1 ; j <= 10 ; j++)
				{
					pw.print(""+i+" * "+j+" = "+(i*j)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
				}
				pw.println("<br><br>");
			}
			pw.println("</body></html>");
		}
	}

}
