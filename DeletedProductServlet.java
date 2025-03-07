package com.chaitu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/RemoveProduct")
public class DeletedProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			String productID = req.getParameter("pcode");
			System.out.println(productID);
			int k = new RemoveProductDAO().removeProduct(productID);
			System.out.println(k);
			if (k > 0) {
				req.setAttribute("msg", "Product Deleted Successfully...<br>");
				req.getRequestDispatcher("Msg.jsp");
			}
			req.getRequestDispatcher("ViewAllProductSuccess.jsp").forward(req, resp);
		}
	}
}
