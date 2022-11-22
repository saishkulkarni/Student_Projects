package com.ty.school.Service;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.school.DAO.TeacherDAO ;
import com.ty.school.DTO.TeacherDTO ;

@Component
public class TeacherService
{
	@Autowired
	TeacherDAO  teacherDAO;
	
	public void saveTeacher(TeacherDTO	teacherDTO)
	{
		teacherDAO.saveTeacher ( teacherDTO );
	}
	
	public TeacherDTO searchTeacher(int tid)
	{
		return teacherDAO.searchTeacher ( tid );
	}
	
	public void deleteTeacher(int tid)
	{
		teacherDAO.deleteTeacher ( tid );
		
	}

	public void updateTeacher( TeacherDTO	 teacherDTO )
	{
		teacherDAO.updateTeacher(teacherDTO);
		
	}

	public List < TeacherDTO > fetchallteacher ( )
	{
		return teacherDAO.fetchallteacher();
	}
	
}
	