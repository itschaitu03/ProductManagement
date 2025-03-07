package com.chaitu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO {

	int k = 0;

	public int addProduct(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into product69 values(?,?,?,?)");
			ps.setString(1, pb.getProductID());
			ps.setString(2, pb.getProductName());
			ps.setFloat(3, pb.getProductPrice());
			ps.setInt(4, pb.getProductQuantity());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
