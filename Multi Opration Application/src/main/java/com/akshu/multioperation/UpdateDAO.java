package com.akshu.multioperation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateDAO
{
	public boolean update(UserBEAN ub , Connection con)
	{
		try 
		{
		PreparedStatement ps = con.prepareStatement("update multiOpration set password = ? where phoneNumber = ?");
		ps.setString(2, ub.getPhoneNumber());
		ps.setString(1, ub.getPassword());
		return ps.executeUpdate()> 0;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1 > 0;
		}
	}

}
