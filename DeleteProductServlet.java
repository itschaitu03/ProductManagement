package com.chaitu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Delete")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>) hs.getAttribute("alist");

			String productID = req.getParameter("pcode");

			Iterator<ProductBean> it = al.iterator();

			while (it.hasNext()) {
				ProductBean pb = it.next();
				if (productID.equals(pb.getProductID())) {
					System.out.println(pb.getProductID());
					req.setAttribute("pbean", pb);
					req.getRequestDispatcher("DeleteProduct.jsp").forward(req, resp);
					break;
				}
			}
		}
	}
}
