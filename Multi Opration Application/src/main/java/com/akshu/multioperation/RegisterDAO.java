package com.akshu.multioperation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO 
{
	public boolean register(UserBEAN ub , Connection con)
	{
		try
		{
			PreparedStatement ps = con.prepareStatement("insert into multiOpration values (?,?,?,?,?,?,?)");
			ps.setString(1, ub.getUserName());
			ps.setString(2, ub.getPassword());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getEmail());
			ps.setString(7, ub.getPhoneNumber());
			
			
			return ps.executeUpdate() > 0;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
	}

}
