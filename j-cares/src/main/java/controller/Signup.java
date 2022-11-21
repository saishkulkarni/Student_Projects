package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = new Customer();
		customer.setName(req.getParameter("name"));
		customer.setEmail(req.getParameter("email"));
		customer.setMobile(Long.parseLong(req.getParameter("phone")));
		customer.setPassword(req.getParameter("password"));

		CustomerDao dao = new CustomerDao();
		dao.insert(customer);
		
		resp.getWriter().print("<html><body><h1>Account Created Successfully</h1></body</html>");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
		dispatcher.include(req, resp);
	}
}
