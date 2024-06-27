package com.akshu.loginregister;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegDAO 
{
	public int insert(UserBean ub , Connection con)
	{
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into loginregister values(?,?,?,?,?,?,?)");
			ps.setString(7, ub.getCountry());
			ps.setString(6, ub.getState());
			ps.setString(4, ub.getAddress());
			ps.setString(5, ub.getPhoneNumber());
			ps.setString(3,ub.getEmail());
			ps.setString(2, ub.getPassword());
			ps.setString(1, ub.getUserName());
			
			return ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return -1;
		}
		
	}

}
