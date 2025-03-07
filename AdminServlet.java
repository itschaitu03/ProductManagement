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
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("pword");
		AdminBean ab = new AdminDAO().login(userName, password);
		if (ab == null) {
			req.setAttribute("msg", "Admin not found...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("abean", ab);
			RequestDispatcher rd = req.getRequestDispatcher("AdminLoginSuccess.jsp");
			rd.forward(req, resp);
		}
	}
}
