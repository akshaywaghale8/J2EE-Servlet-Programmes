package com.akshu.multioperation;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO 
{
	public boolean delete(UserBEAN ub , Connection con)
	{
		boolean flag = false;
		try
		{
		PreparedStatement ps = con.prepareStatement("delete from multiOpration where phoneNumber = ? ");
		ps.setString(1, ub.getPhoneNumber());
		flag =  ps.executeUpdate() > 0;
		
		return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;
		}
	}
}
