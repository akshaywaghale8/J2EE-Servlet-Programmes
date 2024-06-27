package com.akshu.test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/prime")
public class P2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		var pw = res.getWriter();
		
		for(int i = 2 ; i <= 20 ; i++)
		{
			int count = 0;
			int num = 2;
			while( num <= i)
			{
				if(i % num == 0 ) count++;
				num++;
			}
			if(count == 1)
			{
				pw.print(i+" ");
			}
		}
		
		pw.close();
	}

}
