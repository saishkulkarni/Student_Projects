package dao;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Persistence ;

import dto.Patient ;

public class PatDAO
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory ( "myhospital" );
	EntityManager manager=factory.createEntityManager ( );
	EntityTransaction transaction = manager.getTransaction ( );

	public void insertPat(Patient patient)
	{
		transaction.begin ( );
		manager.persist ( patient);
		transaction.commit ( );
	}

	public Patient findPat(int p_id)
	{
		Patient patient =manager.find ( Patient.class , p_id );
		return patient;
	}

	public void updatePat(Patient patient)
	{
		transaction.begin ( );
		manager.merge( patient );
		transaction.commit ( );
	}

	public void deletePat(int p_id)
	{
		Patient patient=findPat ( p_id );
		
		transaction.begin ( );
		manager.remove ( patient );
		transaction.commit ( );
	}
}