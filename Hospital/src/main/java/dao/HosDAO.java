package dao;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Persistence ;

import dto.Hospital ;

public class HosDAO
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory ( "myhospital" );
	EntityManager manager=factory.createEntityManager ( );
	EntityTransaction transaction = manager.getTransaction ( );

public void insertHos(Hospital  hospital)
{
		transaction.begin ( );
		manager.persist ( hospital );
		transaction.commit ( );
}	
	
public Hospital findHos(int h_id)
{
		Hospital hospital  =manager.find (Hospital.class , h_id );
		return hospital;
}

public void updateHos(Hospital  hospital)
{
	transaction.begin ( );
	manager.merge( hospital );
	transaction.commit ( );
}

public void deleteHos(int h_id)
{
	Hospital hospital=findHos ( h_id );
	
	transaction.begin ( );
	manager.remove ( hospital );
	transaction.commit ( );
}

}