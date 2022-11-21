package dao;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Persistence ;

import dto.MedicalRecord ;

public class MRDAO
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory ( "myhospital" );
	EntityManager manager=factory.createEntityManager ( );
	EntityTransaction transaction = manager.getTransaction ( );

	public void insertMR(MedicalRecord medicalRecord)
	{
		transaction.begin ( );
		manager.persist ( medicalRecord);
		transaction.commit ( );
	}

	public MedicalRecord findMR(int mr_id)
	{
		MedicalRecord medicalRecord =manager.find ( MedicalRecord.class , mr_id );
		return medicalRecord;
	}

	public void updateMR(MedicalRecord medicalRecord)
	{
		transaction.begin ( );
		manager.merge( medicalRecord );
		transaction.commit ( );
	}

	public void deleteMr(int mr_id)
	{
		MedicalRecord medicalRecord=findMR ( mr_id );
		
		transaction.begin ( );
		manager.remove ( medicalRecord );
		transaction.commit ( );
	}
}