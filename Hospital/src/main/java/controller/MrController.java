package controller;

import java.util.List ;
import java.util.Scanner ;
import dao.MRDAO ;
import dao.PatDAO ;
import dto.MedicalRecord ;
import dto.Patient ;

public class MrController
{
static Scanner scanner=new Scanner ( System.in );
	
	public static void main ( String [ ] args )
	{
		PatDAO patDAO=new PatDAO ( );
		MRDAO mrdao=new MRDAO ( );
	
		boolean rep=true;
		while(rep) 
		{
		System.out.print ( "\nSelect one option\n*********************\n1.Insert Record \n2.Fetch Record\n3.Delete Record\n4.Update Record\n5.Exit\n**********************\nEnter your choice: " );
		int choice = scanner.nextInt ( );
		
		switch ( choice )
	{
		case 1 :
		{

			MedicalRecord mRecord=new MedicalRecord ( );
			System.out.println ( "Enter Medical Record Id: " ) ;
			int r_id=scanner.nextInt ( );
			mRecord.setR_id ( r_id );
			
			System.out.println ( "Enter Medical Record Date: " ) ;
			String r_date=scanner.next ( );
			mRecord.setR_date ( r_date );
			
			System.out.println ( "Enter problem: " ) ;
			String r_problem=scanner.next ( );
			mRecord.setR_problem ( r_problem );
			
			System.out.println ( "Enter patient id : " ) ;
			int p_id=scanner.nextInt ( );
			
			Patient patient=patDAO.findPat ( p_id );
			if(patient!=null)
			{
			mRecord.setPatient ( patient );
			
			mrdao.insertMR ( mRecord );
			
			List<MedicalRecord> lt=patient.getMedicalRecords ( );
			lt.add ( mRecord );
			
			patient.setMedicalRecords ( lt );
			
			patDAO.updatePat ( patient );
			System.out.println ( "Data inserted..." ) ;
			}
			else
			{
				System.out.println ( "Record not found.." ) ;
			}
				break ;
			}

		case 2 :
		{
			System.out.println ( "Enter Id : " ) ;
			int mr_id=scanner.nextInt ( );
			
			MedicalRecord medicalRecord=mrdao.findMR ( mr_id );
			
			System.out.println ( "\nMedical Record details:\nMedical Record Id: "+medicalRecord.getR_id ( )+"\nMedical Record Name: " +medicalRecord.getR_date ( )+"\nProblem: "+medicalRecord.getR_problem ( )+"\nPatient Name : "+medicalRecord.getPatient ( ).getP_name ( )) ;
			break;
		}
	
		case 3 :
		{
			System.out.println ( "Enter Id : " ) ;
			int mr_id=scanner.nextInt ( );
			
			mrdao.deleteMr ( mr_id );
			System.out.println ( "Data removed..." ) ;
			break ;
		}
		
		case 4 :
		{
			boolean rep1=true;
			while(rep1)
	{
			System.out.println ("Enter id: "  ) ;
			int mr_id=scanner.nextInt ( );
			
			MedicalRecord mRecord2=mrdao.findMR ( mr_id );
			
			System.out.println ( "\nSelect what you want to update\n1.Date\n2.Problem\n3.Patient\n4.Exit" ) ;
			int choice1=scanner.nextInt ( );
			
			switch ( choice1 )
	{
			case 1 :
			{
				System.out.println ( "Enter new Date: " ) ;
				String mr_date=scanner.next ( );
				
				mRecord2.setR_date ( mr_date );			
				
				mrdao.updateMR ( mRecord2 );
				
			}
			
			case 2 :
			{
				System.out.println ( "Enter new problem: " ) ;
				String problem=scanner.next( );
				
				mRecord2.setR_problem ( problem );
				
				mrdao.updateMR ( mRecord2 );
			}
			case 3 :
			{
				System.out.println ( "Enter new patient id: " ) ;
				int p_id=scanner.nextInt ( );
				
				Patient patient2 = patDAO.findPat ( p_id );
				
				mRecord2.setPatient ( patient2 );
				
				mrdao.updateMR ( mRecord2 );
			}
			
			case 4:
			{
				System.out.println ( "************Thank you**************" ) ;
				rep1=false;
				break;
			}
			default :
				{
					System.out.println ( "Select proper option..." ) ;
					break ;
				}
	}
	}
			break ;
		}
		case 5 :
		{
			System.out.println ( "***************Thank you******************" ) ;
			rep=false;
			break ;
		}
		default :
		{
			System.out.println ( "Select proper Option..." ) ;
			break ;
		}
	}
	}
	}
}