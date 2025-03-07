package com.chaitu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignINCustomerDAO {

	public CustomerBean cb;

	public CustomerBean login(String userName, String password) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from customer70 where userName=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cb = new CustomerBean();
				cb.setUserName(rs.getString(1));
				cb.setEmailID(rs.getString(2));
				cb.setPassword(rs.getString(3));
				cb.setPhNo(rs.getLong(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cb;
	}
}
