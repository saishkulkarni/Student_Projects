package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Employee;

@WebServlet("/signup")
public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Employee employee = new Employee();
		employee.setName(req.getParameter("name"));
		employee.setEmail(req.getParameter("email"));
		employee.setPassword(req.getParameter("password"));
		employee.setMobile(Long.parseLong(req.getParameter("mobile")));

		Dao dao = new Dao();
		dao.saveEmployee(employee);

		resp.getWriter().print("<h1>Account Created Successfully</h1>");

		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
