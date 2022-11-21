package dao;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Persistence ;

import dto.Doctor ;

public class DocDAO
{
EntityManagerFactory factory=Persistence.createEntityManagerFactory ( "myhospital" );
EntityManager manager=factory.createEntityManager ( );
EntityTransaction transaction = manager.getTransaction ( );

public void insertDoc(Doctor doctor)
{
	transaction.begin ( );
	manager.persist ( doctor );
	transaction.commit ( );
}

public Doctor findDoc(int d_id)
{
	Doctor doctor =manager.find ( Doctor.class , d_id );
	return doctor;
}

public void updateDoc(Doctor doctor)
{
	
	transaction.begin ( );
	manager.merge( doctor );
	transaction.commit ( );
}

public void deleteDoc(int d_id)
{
	Doctor doctor=findDoc ( d_id );
	
	transaction.begin ( );
	manager.remove ( doctor );
	transaction.commit ( );
}
}