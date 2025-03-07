package com.chaitu;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ViewAllProductForCustomer")
public class ViewAllProductForCustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			ArrayList<ProductBean> al = new ViewAllProductForCustomerDAO().view();
			System.out.println("arraylist is" + al);
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllProductForCustomerSuccess.jsp").forward(req, resp);
		}
	}
}
