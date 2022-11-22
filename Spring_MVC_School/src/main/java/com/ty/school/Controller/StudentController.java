package com.ty.school.Controller;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.ModelAttribute ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.servlet.ModelAndView ;

import com.ty.school.DTO.StudentDTO ;
import com.ty.school.Service.StudentService ;


@Controller
public class StudentController
{
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/loadStudent")
public ModelAndView loadStudent()
{
	ModelAndView modelAndView=new ModelAndView ("AddStudent.jsp" );
	StudentDTO student=new StudentDTO ( );
	modelAndView.addObject ("student",student );
	return modelAndView;
}
	
	@RequestMapping("/saveStudent")
public ModelAndView saveStudent(@ModelAttribute StudentDTO studentDTO)
{
	studentService.saveStudent ( studentDTO );
	ModelAndView modelAndView=new ModelAndView ("index.jsp");
	modelAndView.addObject ( "msg","Data Added Successfully");
	return modelAndView;
}	
	
	@RequestMapping("/searchStudent")
public ModelAndView searchStudent(@RequestParam String sid)
{
		int sid1 = Integer.parseInt ( sid );
	StudentDTO student = studentService.searchStudent ( sid1 );
	ModelAndView modelAndView=new ModelAndView ("viewstudent.jsp");
	modelAndView.addObject ( "student",student );
	return modelAndView;
}	
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@RequestParam int Id)
	{
		studentService.deleteStudent ( Id );
		ModelAndView modelAndView=new ModelAndView ("index.jsp");
		modelAndView.addObject ( "msg","Data removed Successfully");
		return modelAndView;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@RequestParam int Id)
	{
		StudentDTO studentDTO=studentService.searchStudent ( Id );
		ModelAndView modelAndView=new ModelAndView ("updateStudent.jsp");
		modelAndView.addObject ( "student",studentDTO);
		return modelAndView;
	}
	
	@RequestMapping("/updatestudentbyid")
	public ModelAndView updateStudentbyid(@ModelAttribute StudentDTO studentDTO)
	{
		studentService.updateStudent ( studentDTO );
		ModelAndView modelAndView=new ModelAndView ("index.jsp");
		modelAndView.addObject ( "msg","Data Updated Successfully");
		return modelAndView;
	}
	
	@RequestMapping("/fetchall")
	public ModelAndView fetchallStudentbyid()
	{
		List < StudentDTO > students = studentService.fetchallstudent ( );

		ModelAndView modelAndView=new ModelAndView ("fetchall.jsp");
		modelAndView.addObject ( "students",students );
		return modelAndView ;
		
	}
	
}
