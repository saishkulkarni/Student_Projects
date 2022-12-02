package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Employee;

@WebServlet("/login")
public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	Dao dao=new Dao();
	List<Employee> list=dao.login(email);
	
	if(list.isEmpty())
	{
		resp.getWriter().print("<h1>Enter proper Email Id</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	else
	{
		Employee employee=list.get(0);
		if(password.equals(employee.getPassword()))
		{
//			resp.getWriter().print("<html><body><table border='1px solid black'><tr><th>id</th><th>name</th><th>mobile</th><th>email</th><tr>");
//			resp.getWriter().print("<tr><td>"+employee.getId()+"</td>");
//			resp.getWriter().print("<td>"+employee.getName()+"</td>");
//			resp.getWriter().print("<td>"+employee.getMobile()+"</td>");
//			resp.getWriter().print("<td>"+employee.getEmail()+"</td></tr></body</html>");
//		
			req.getSession().setAttribute("employee", employee);
			req.getSession().setMaxInactiveInterval(5);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}  
		
		else
		{
			resp.getWriter().print("<h1>Enter proper Password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		
		}
	}
}
}
