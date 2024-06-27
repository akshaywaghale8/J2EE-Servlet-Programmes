package com.akshu.multioperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class LoginDAO 
{
	public boolean login(UserBEAN ub , Connection con)
	{
		boolean flag = false;
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from multiOpration where userName = ? AND password = ?");
		
			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getPassword());
			ResultSet rs = ps.executeQuery();
			
			flag =  rs.next();
			return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;
		}
		
	}
}
