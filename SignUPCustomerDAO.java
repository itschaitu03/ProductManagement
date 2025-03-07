package com.chaitu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignUPCustomerDAO {

	int k = 0;

	public int login(CustomerBean cb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into customer70 values(?,?,?,?)");
			ps.setString(1, cb.getUserName());
			ps.setString(2, cb.getEmailID());
			ps.setString(3, cb.getPassword());
			ps.setLong(4, cb.getPhNo());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
