package session_management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	User user=new User();
	user.setEmail(email);
	user.setPassword(password);
	
	UserDao dao=new UserDao();
	dao.signup(user);
	resp.setContentType("text/html");
	resp.getWriter().print("Signup Succesfull");
	RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
	requestDispatcher.include(req, resp);
}
}
