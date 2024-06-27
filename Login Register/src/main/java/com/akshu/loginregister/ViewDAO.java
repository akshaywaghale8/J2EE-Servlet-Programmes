package com.akshu.loginregister;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ViewDAO 
{
	public ArrayList<String> viewUsers(Connection con)
	{
		ArrayList<String> al = new ArrayList<>();
		try 
		{
			Statement s = con.createStatement();
			
			ResultSet rs = s.executeQuery("select * from loginRegister");
		
			while(rs.next())
			{
				al.add(rs.getString("userName"));
			}
			return al;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return al;
		}
	}
}
