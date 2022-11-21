package mvc_calculator;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculator 
{

	@RequestMapping("add")
	void add(ServletRequest req,ServletResponse res) throws IOException
	{
		int a=Integer.parseInt(req.getParameter("num1"));
		int b=Integer.parseInt(req.getParameter("num2"));
		int c=a+b;
		res.getWriter().print("The sum is "+c);
	}
	
	@RequestMapping("sub")
	void sub(@RequestParam("num1") int a,@RequestParam("num2") int b,ServletResponse res) throws IOException
	{
		
		int c=a-b;
		res.getWriter().print("<h1>The difference is "+c+"</h1>");
	}
	
	@RequestMapping("mul")
	ModelAndView mul(@RequestParam("num1") int a,@RequestParam("num2") int b) throws IOException
	{
		double c=a*b;
		ModelAndView view=new ModelAndView();
		view.setViewName("index.jsp");
		view.addObject("c",c);
		return view;
	}
	
	@RequestMapping("div")
	ModelAndView div(@RequestParam("num1") double a,@RequestParam("num2") double b) throws IOException
	{
		double c=a/b;
		ModelAndView view=new ModelAndView("index.jsp");
		view.addObject("c",c);
		return view;
	}
}
