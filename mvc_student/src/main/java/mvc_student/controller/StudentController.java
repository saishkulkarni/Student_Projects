package mvc_student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc_student.dao.StudentDao;
import mvc_student.dto.Student;

@Controller
public class StudentController
{
	@Autowired
	Student student;
	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("addStudent")
	public ModelAndView loadStudent()
	{
		ModelAndView andView=new ModelAndView("addStudent.jsp");
		andView.addObject("student",student);
		return andView;
	}
	
	@RequestMapping("saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student)
	{
		student.setTotalmarks(student.getEnglish()+student.getMaths()+student.getScience());
		student.setPercentage(student.getTotalmarks()/3);
		dao.saveStudent(student);
		ModelAndView andView=new ModelAndView("index.jsp");
		andView.addObject("msg","Data Added Successfully");
		return andView;
	}
	
	@RequestMapping("viewByid")
	public ModelAndView viewById(@RequestParam int id)
	{
		Student student=dao.fetchStudentById(id);
		if(student==null)
		{
			ModelAndView view=new ModelAndView("index.jsp");
			view.addObject("msg","Data Not Found");
			return view;
		}
		else {
		List<Student> students=new ArrayList<>();
		students.add(student);
		ModelAndView view=new ModelAndView("viewStudent.jsp");
		view.addObject("students",students);
		return view;
		}
	}
	
	@RequestMapping("viewAllStudent")
	public ModelAndView viewAll()
	{
		List<Student> students = dao.fetchAll();
		if(students.isEmpty())
		{
			ModelAndView view=new ModelAndView("index.jsp");
			view.addObject("msg","Data Not Found");
			return view;
		}
		else {
		ModelAndView view=new ModelAndView("viewStudent.jsp");
		view.addObject("students",students);
		return view;
		}
	}
	
	@RequestMapping("deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int id)
	{
		dao.removeStudent(id);
		ModelAndView view=new ModelAndView("index.jsp");
		view.addObject("msg","Data Removed Successfully");
		return view;
	}
}
