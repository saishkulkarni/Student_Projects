package com.ty.school.Service;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.school.DAO.StudentDAO ;
import com.ty.school.DTO.StudentDTO ;

@Component
public class StudentService
{
	@Autowired
	StudentDAO studentDAO;
	
	public void saveStudent(StudentDTO studentDTO)
	{
		studentDAO.saveStudent ( studentDTO );
	}
	
	public StudentDTO searchStudent(int sid)
	{
		return studentDAO.searchStudent ( sid );
	}
	
	public void deleteStudent(int sid)
	{
		studentDAO.deleteStudent ( sid );
		
	}

	public void updateStudent ( StudentDTO studentDTO )
	{
		studentDAO.updateStudent(studentDTO);
		
	}

	public List < StudentDTO > fetchallstudent ( )
	{
		return studentDAO.fetchallstudent();
	}
	
}
	