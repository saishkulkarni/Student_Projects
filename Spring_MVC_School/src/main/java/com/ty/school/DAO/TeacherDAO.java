package com.ty.school.DAO;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Query ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.school.DTO.TeacherDTO ;

@Component
public class TeacherDAO
{
	@Autowired
EntityManagerFactory entityManagerFactory;
	
	
	public void saveTeacher(TeacherDTO teacher)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.persist ( teacher );
		entityTransaction.commit ( );
		
	}
	
	public TeacherDTO searchTeacher(int tid)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		return	entityManager.find ( TeacherDTO.class , tid );
	}
	
	public void deleteTeacher(int tid)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		TeacherDTO teacher = entityManager.find ( TeacherDTO.class , tid );
		entityTransaction.begin ( );
		entityManager.remove ( teacher );
		entityTransaction.commit ( );
		
	}

	public void updateTeacher ( TeacherDTO	 teacherDTO )
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.merge ( teacherDTO );
		entityTransaction.commit ( );
		
	}

	public List < TeacherDTO > fetchallteacher ( )
	{

		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
	Query query = entityManager.createQuery ( "select s from TeacherDTO s",TeacherDTO.class );
	List<TeacherDTO> teachers = query.getResultList ( );
		return teachers;
	}
}
