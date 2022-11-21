package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import dto.Product;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Product product=new Product();
	product.setName(req.getParameter("pname"));
	product.setCost(Double.parseDouble(req.getParameter("pcost")));
	
	ProductDao dao=new ProductDao();
	dao.insert(product);
	
	resp.getWriter().print("<html><body><h1>Product Added Successfully</h1></body></html>");
}
}
