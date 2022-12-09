package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;

@WebServlet("/login")
public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	UserDao dao=new UserDao();
	List<User> list=dao.login(email);
	if(list.isEmpty())
	{
		resp.getWriter().print("<h1>Enter proper email Id</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	else 
	{
		User user=list.get(0);
		if(user.getPassword().equals(password))
		{
			req.getSession().setAttribute("user", user);
			if(user.getRole().equals("customer"))
			{
				resp.getWriter().print("<h1>Login Success</h1>");
				req.getRequestDispatcher("customerhomepage.html").include(req, resp);
			}
			else {
				resp.getWriter().print("<h1>Login Success</h1>");
				req.getRequestDispatcher("adminhomepage.html").include(req, resp);
			}
		}
		else
		{
			resp.getWriter().print("<h1>Enter proper Password</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	
	}
}
}
