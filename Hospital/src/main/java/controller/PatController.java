package controller;

import java.util.List ;
import java.util.Scanner ;
import dao.HosDAO ;
import dao.MRDAO ;
import dao.PatDAO ;
import dto.Hospital ;
import dto.MedicalRecord ;
import dto.Patient ;

public class PatController
{
	static Scanner scanner=new Scanner ( System.in );
	
	public static void main ( String [ ] args )
	{
		HosDAO hosDAO=new HosDAO ( );
		PatDAO patDAO=new PatDAO ( );
	
		boolean rep=true;
		while(rep) 
		{
		System.out.print ( "\nSelect one option\n*********************\n1.Insert Record \n2.Fetch Record\n3.Delete Record\n4.Update Record\n5.Exit\n**********************\nEnter your choice: " );
		int choice = scanner.nextInt ( );
		
		switch ( choice )
	{
		case 1 :
		{
			
			Patient patient =new Patient ( );
			System.out.println ( "Enter Patient ID:" ) ;
			int p_id=scanner.nextInt ( );
			patient.setP_id ( p_id );
			
			System.out.println ( "Enter Patient Name:" ) ;
			String p_name=scanner.next ( );
			patient.setP_name ( p_name );
			
			System.out.println ( "Enter Patient Diagnosis: " ) ;
			String p_diagnosis=scanner.next ( );
			patient.setP_diagnosis ( p_diagnosis );
			
			System.out.println ( "Enter Patient Address: " ) ;
			String p_address=scanner.next( );
			patient.setP_address ( p_address );
			
			System.out.println ( "Enter Hospital_id of Patient: " ) ;
			int h_id=scanner.nextInt ( );
			
			Hospital hospital  =hosDAO.findHos ( h_id );
			if(hospital!=null)
			{
			patient.setHospital ( hospital );

			patDAO.insertPat ( patient );
			
			List < Patient > list=hospital.getPatients ( );
			list.add ( patient);
			
			hospital.setPatients ( list );
			
			hosDAO.updateHos ( hospital );
			System.out.println ( "Data inserted..." ) ;
			}
			else
			{
				System.out.println ( "No Hospital found..." ) ;
			}
			break ;
		}
		
		case 2 :
		{
			System.out.println ( "Enter Id : " ) ;
			int p_id=scanner.nextInt ( );
			
			Patient patient1 = patDAO.findPat ( p_id );
			System.out.print( "\nPatient details:\n*********************\nPatient_id: "+patient1.getP_id ( )+"\nPatient_Name: " +patient1.getP_name ( )+"\nPatient Diagnosis: "+patient1.getP_diagnosis ( )+"\nPatient Address: "+patient1.getP_address ( )+"\nPatient_Hospital name: "+patient1.getHospital ( ).getH_name ( )) ;
		
			System.out.print ( "\nMedical Record of patient : " ) ;
			
			List < MedicalRecord > medicalRecords = patient1.getMedicalRecords ( );
			for(MedicalRecord mr1:medicalRecords) 
			{
			System.out.print("\n"+mr1.getR_problem ( ) ) ;	
			System.out.println("\n"+mr1.getR_date  ( ) ) ;	
			}
			break;
		}
	
		case 3 :
		{
			System.out.println ( "Enter Id : " ) ;
			int p_id=scanner.nextInt ( );
			
			Patient patient = patDAO.findPat ( p_id );
			
			List < MedicalRecord > list=patient.getMedicalRecords ( );
			 for(MedicalRecord l:list)
			 {
				MRDAO mrdao=new MRDAO ( );
				mrdao.deleteMr ( l.getR_id ( ) );
				System.out.println ( "Medical records removed..." ) ;
			 }
			
			patDAO.deletePat ( p_id );
			System.out.println ( "Data removed..." ) ;
			break ;
		}
		
		case 4 :
		{
			boolean rep1=true;
			while(rep1)
	{
			System.out.println ("Enter id: "  ) ;
			int p_id=scanner.nextInt ( );
			
			Patient patient2=patDAO.findPat ( p_id );
			
			System.out.println ( "\nSelect what you want to update\n1.Name\n2.Diagnosis\n3.Address \n4.Hospital_id\n5.Exit" ) ;
			int choice1=scanner.nextInt ( );
			
			switch ( choice1 )
	{
			case 1 :
			{
				System.out.println ( "Enter new Name: " ) ;
				String p_name=scanner.next ( );
				
				patient2.setP_name ( p_name );
				
			}
			case 2 :
			{
				System.out.println ( "Enter new Diagnosis: " ) ;
				String diagnosis=scanner.next( );
				
				patient2.setP_diagnosis ( diagnosis );
				
				patDAO.updatePat ( patient2 );
			}
			case 3 :
			{
				System.out.println ( "Enter new Address: " ) ;
				String p_address=scanner.next ( );
				
				patient2.setP_address ( p_address );
				
				patDAO.updatePat ( patient2 );
			}
			case 4 :
			{
				System.out.println ( "Enter new Hospital_id: " ) ;
				int h_id=scanner.nextInt ( );
				
				Hospital hospital1=hosDAO.findHos ( patient2.getP_id ( ));
				hospital1.setH_id ( h_id );
				
				patient2.setHospital ( hospital1);
				
				patDAO.updatePat ( patient2 );
			}
			case 5:
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