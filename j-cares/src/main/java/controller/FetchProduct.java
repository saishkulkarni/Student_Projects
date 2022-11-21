package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dto.Product;

@WebServlet("/fetchProduct")
public class FetchProduct extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ProductDao dao=new ProductDao();
	List<Product> list=dao.fetchProduct();
	
	HttpSession session=req.getSession();
	session.setAttribute("list", list);
	
	resp.sendRedirect("home.jsp");
}
}
