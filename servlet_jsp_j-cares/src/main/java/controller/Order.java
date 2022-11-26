package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import dto.Product;

@WebServlet("/order")
public class Order extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Product> list2=new ArrayList<>();
		
		ProductDao dao=new ProductDao();
		
		for(char i='a';i<'z';i++)
		{
			String x=req.getParameter(i+"");
			if(x==null)
			{
				continue;
			}
			else {
				int a = Integer.parseInt(x);
				list2.add( dao.fetchProduct(a));
			}
			
		}
		HttpSession httpSession=req.getSession();
		httpSession.setAttribute("list2", list2);
		
		resp.sendRedirect("FinalOrder.jsp");
	}
}
