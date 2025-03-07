package com.chaitu;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			ProductBean pb = new ProductBean();
			pb.setProductID(req.getParameter("pcode"));
			pb.setProductName(req.getParameter("pname"));
			pb.setProductPrice(Float.parseFloat(req.getParameter("pprice")));
			pb.setProductQuantity(Integer.parseInt(req.getParameter("pqty")));
			AddProductDAO apd = new AddProductDAO();
			int k = apd.addProduct(pb);
			if (k > 0) {
				req.setAttribute("msg", "Product Added Successfully...<br>");
				RequestDispatcher rd = req.getRequestDispatcher("AddProductSuccess.jsp");
				rd.forward(req, resp);
			}
		}

	}
}
