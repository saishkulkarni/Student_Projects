package com.ty.school.Controller;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.ModelAttribute ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.servlet.ModelAndView ;

import com.ty.school.DTO.TeacherDTO ;
import com.ty.school.Service.TeacherService ;

@Controller
public class TeacherController
{

	@Autowired
	TeacherService teacherService;
	
	@RequestMapping("/loadTeacher")
public ModelAndView loadTeacher()
{
	ModelAndView modelAndView=new ModelAndView ("AddTeacher.jsp" );
	TeacherDTO teacherDTO=new TeacherDTO();
	modelAndView.addObject ("teacher",teacherDTO );
	return modelAndView;
}
	
	@RequestMapping("/saveTeacher")
public ModelAndView saveTeacher(@ModelAttribute TeacherDTO teacherDTO)
{
		teacherService.saveTeacher ( teacherDTO );
	ModelAndView modelAndView=new ModelAndView ("index.jsp");
	modelAndView.addObject ( "msg","Data Added Successfully");
	return modelAndView;
}	
	
	@RequestMapping("/searchTeacher")
	public ModelAndView searchTeacher(@RequestParam int tid)
	{
		TeacherDTO teacher = teacherService.searchTeacher ( tid );
		ModelAndView modelAndView=new ModelAndView ("viewteacher.jsp");
		modelAndView.addObject ( "teacher",teacher );
		return modelAndView;
	}	
		@RequestMapping("/deleteTeacher")
		public ModelAndView deleteTeacher(@RequestParam int Id)
		{
			teacherService.deleteTeacher ( Id );
			ModelAndView modelAndView=new ModelAndView ("index.jsp");
			modelAndView.addObject ( "msg","Data removed Successfully");
			return modelAndView;
		}
		
		@RequestMapping("/updateTeacher")
		public ModelAndView updateTeacher(@RequestParam int Id)
		{
			TeacherDTO teacherDTO=teacherService.searchTeacher ( Id );
			ModelAndView modelAndView=new ModelAndView ("updateTeacher.jsp");
			modelAndView.addObject ( "teacher",teacherDTO);
			return modelAndView;
		}
		
		@RequestMapping("/updateteacherbyid")
		public ModelAndView updateTeacherbyid(@ModelAttribute TeacherDTO teacherDTO)
		{
			
			teacherService.updateTeacher ( teacherDTO );
			ModelAndView modelAndView=new ModelAndView ("index.jsp");
			modelAndView.addObject ( "msg","Data Updated Successfully");
			return modelAndView;
		}
		
		@RequestMapping("/fetchallt")
		public ModelAndView fetchallTeacherbyid()
		{
			List < TeacherDTO > teachers = teacherService.fetchallteacher ( );

			ModelAndView modelAndView=new ModelAndView ("fetchallt.jsp");
			modelAndView.addObject ( "teachers",teachers );
			return modelAndView ;
			
		}
	
	
}
