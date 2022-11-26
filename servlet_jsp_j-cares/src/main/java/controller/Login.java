package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customer;

@WebServlet("/login")
public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("name");
	String password = req.getParameter("password");

	CustomerDao dao = new CustomerDao();
	List<Customer> list=dao.login(username);
	
	RequestDispatcher rd = req.getRequestDispatcher("login.html");
	PrintWriter writer = resp.getWriter();
	
	if (list.isEmpty()) {
		writer.print("<h1>Invalid Email adress</h1>");
		rd.include(req, resp);
	} 
	else 
	{
		Customer customer=list.get(0);
			
		if (password.equals(customer.getPassword()))
		{
			resp.sendRedirect("fetchProduct");
		} 
		
		else 
		{
			writer.print("<h1>Wrong Password</h1>");
			rd.include(req, resp);
		}
	}
}
}
