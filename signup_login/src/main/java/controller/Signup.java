package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.UserDao;
import dto.User;

@WebServlet("/signup")
public class Signup extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		
		String cname=getServletContext().getInitParameter("cname");

		res.getWriter().print("<h1>"+cname+"</h1>");
		
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setDob(dob);
		user.setGender(gender);
		
		UserDao dao=new UserDao();
		dao.signup(user);
		
		res.getWriter().print("<h1>Account created successfully</h1>");
		
	}

}
