package com.ty.school.DAO;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Query ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.school.DTO.StudentDTO ;

@Component
public class StudentDAO
{
	@Autowired
EntityManagerFactory entityManagerFactory;
	
	public void saveStudent(StudentDTO student)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.persist ( student );
		entityTransaction.commit ( );
		
	}
	
	public StudentDTO searchStudent(int sid)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		return	entityManager.find ( StudentDTO.class , sid );
	}
	
	public void deleteStudent(int sid)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		StudentDTO student = entityManager.find ( StudentDTO.class , sid );
		entityTransaction.begin ( );
		entityManager.remove ( student );
		entityTransaction.commit ( );
		
	}

	public void updateStudent ( StudentDTO studentDTO )
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.merge ( studentDTO );
		entityTransaction.commit ( );
		
	}

	public List < StudentDTO > fetchallstudent ( )
	{

		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
	Query query = entityManager.createQuery ( "select s from StudentDTOs",StudentDTO.class );
	List<StudentDTO> students = query.getResultList ( );
		return students;
	}
}
