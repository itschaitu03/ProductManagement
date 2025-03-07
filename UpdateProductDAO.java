package com.chaitu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO {

	public int k = 0;

	public int update(ProductBean pb) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con
					.prepareStatement("update product69 set productPrice=?, productQuantity=? where productID=?");
			ps.setFloat(1, pb.getProductPrice());
			ps.setInt(2, pb.getProductQuantity());
			ps.setString(3, pb.getProductID());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
