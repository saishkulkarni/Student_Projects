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

@WebServlet(urlPatterns = "/fetchall")
public class FetchAll extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("employee")!=null)
		{
		Dao dao = new Dao();
		List<Employee> list = dao.fetchAll();
		req.setAttribute("list", list);
		req.getRequestDispatcher("fetchAll.jsp").forward(req, resp);
		}
		else
		{
			resp.getWriter().print("<h1>Session Expired</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		}
	}
}
