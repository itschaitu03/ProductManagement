package com.chaitu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con = null;
	static {
		try {
			Class.forName(DBinfo.driver);
			con = DriverManager.getConnection(DBinfo.DBurl, DBinfo.DBname, DBinfo.DBpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;

	}
}
