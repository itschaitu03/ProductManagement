package com.chaitu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/SignIN")
public class SignINCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		CustomerBean cb = new SignINCustomerDAO().login(userName, password);
		if (cb == null) {
			req.setAttribute("msg", "Customer not found...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("cbean", cb);
			req.getRequestDispatcher("SignINSuccess.jsp").forward(req, resp);

		}
	}
}
