package httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import session_management.User;
import session_management.UserDao;

@WebServlet("/loginsession")
public class Login extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	String id=req.getParameter("sessionid");
	
	UserDao userdao = new UserDao();
	User user = userdao.login(email);

	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	
	PrintWriter writer=resp.getWriter();
	if (user == null) {
		writer.print("<h1>Invalid Email adress</h1>");
		rd.include(req, resp);
	} 
	else 
	{
		if (password.equals(user.getPassword()))
		{
			System.out.println(id);
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			resp.sendRedirect("home.jsp");
		} 
		else 
		{
			writer.print("<h1>Wrong Password</h1>");
			rd.include(req, resp);
		}
	}
}
}

