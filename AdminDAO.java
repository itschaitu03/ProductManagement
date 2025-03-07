package com.chaitu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

	AdminBean ab = null;

	public AdminBean login(String userName, String password) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from admin70 where uname=? and pword=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ab = new AdminBean();
				ab.setUserName(rs.getString(1));
				ab.setPassword(rs.getString(2));
				ab.setFirstName(rs.getString(3));
				ab.setLastName(rs.getString(4));
				ab.setCity(rs.getString(5));
				ab.setEmailID(rs.getString(6));
				ab.setPhNo(Long.parseLong(rs.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
