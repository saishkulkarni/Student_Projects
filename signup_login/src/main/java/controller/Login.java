package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String emph = req.getParameter("emph");
		String password = req.getParameter("password");
		
	String cname=getServletContext().getInitParameter("cname");
		resp.getWriter().print("<h1>"+cname+"</h1>");
		UserDao dao = new UserDao();
		try {
			long mobile = Long.parseLong(emph);
			List<User> list = dao.loginMobile(mobile);

			if (list.isEmpty()) {
				resp.getWriter().print(
						"<h1>Enter proper mobile number</h1><br><a href='login2.html'>click here to login again</a>");

			} else {
				User user = list.get(0);
				if (password.equals(user.getPassword())) {
					resp.getWriter().print("<h1>Login Successfull</h1>");
				} else {
					resp.getWriter().print(
							"<h1>Enter proper password</h1><br><a href='login2.html'>click here to login again</a>");
				}
			}
		} catch (Exception e) {
			User user = dao.login(emph);
			if (user == null) {
				resp.getWriter()
						.print("<h1>Enter proper email id</h1><br><a href='	login.html'>click here to login again</a>");
			} else {
				if (password.equals(user.getPassword())) {
					resp.getWriter().print("<h1>Login Successfull</h1>");
				} else {
					resp.getWriter().print(
							"<h1>Enter proper password</h1><br><a href='login.html'>click here to login again</a>");
				}
			}
		}

	}
}
