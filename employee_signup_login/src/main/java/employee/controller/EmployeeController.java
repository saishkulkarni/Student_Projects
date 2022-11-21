package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employee.dao.EmployeeDao;
import employee.dto.Employee;

@Controller
public class EmployeeController 
{

	@Autowired
	Employee employee;
	
	@Autowired
	EmployeeDao dao;
	
	@RequestMapping("load")
	public ModelAndView load()
	{
		ModelAndView andView=new ModelAndView("signup.jsp");
		andView.addObject("employee",employee);
		return andView;
	}
	
	@RequestMapping("signup")
	public ModelAndView signup(@ModelAttribute Employee employee)
	{
		dao.signup(employee);
		ModelAndView andView=new ModelAndView("login.jsp");
		andView.addObject("msg","Account created Successfully");
		return andView;
	}
	
	@RequestMapping("login")
	public ModelAndView login(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		List<Employee> list=dao.login(email);
		ModelAndView andView=new ModelAndView();
		
		if(list.isEmpty())
		{
			andView.setViewName("login.jsp");
			andView.addObject("msg","Enter Proper email id");
		}
		else
		{
			Employee employee=list.get(0);
			if(employee.getPassword().equals(password))
			{
				andView.setViewName("home.jsp");
				andView.addObject("msg","Login Success");
			}
			else {
				andView.setViewName("login.jsp");
				andView.addObject("msg","Enter Proper Password");
			}
		}
		return andView;
	}
}
