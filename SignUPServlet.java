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
@WebServlet("/SignUP")
public class SignUPServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		if (hs == null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			CustomerBean cb = new CustomerBean();
			cb.setUserName(req.getParameter("username"));
			cb.setEmailID(req.getParameter("email"));
			cb.setPassword(req.getParameter("password"));
			String parameter = req.getParameter("phoneNo");
			System.out.println(parameter);
			cb.setPhNo(Long.parseLong(req.getParameter("phoneNo")));
			SignUPCustomerDAO sgu = new SignUPCustomerDAO();
			int k = sgu.login(cb);
			if (k > 0) {
				hs.setAttribute("cbean", cb);
				RequestDispatcher rd = req.getRequestDispatcher("SignUPCustomer.jsp");
				rd.forward(req, resp);
			}
		}
	}
}
