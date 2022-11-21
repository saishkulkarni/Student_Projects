package controller;

import java.util.List ;
import java.util.Scanner ;
import dao.HosDAO ;
import dto.Doctor ;
import dto.Hospital ;
import dto.Patient ;

public class HosController
{
	static Scanner scanner=new Scanner ( System.in );
	
	public static void main ( String [ ] args )
	{
		HosDAO hosDAO=new HosDAO ( );
		
		boolean rep=true;
		while(rep) 
		{
		System.out.print ( "\nSelect one option\n*********************\n1.Insert Record \n2.Fetch Record\n4.Update Record\n5.Exit\n**********************\nEnter your choice: " );
		int choice = scanner.nextInt ( );
		
		switch ( choice )
	{
		case 1 :
		{
			Hospital hospital1=new Hospital ( );
			
			System.out.println ( "Enter Hospital ID: " ) ;
			int h_id=scanner.nextInt ( );
			hospital1.setH_id ( h_id );
			
			System.out.println ( "Enter Hospital Name: " ) ;
			String h_name=scanner.next ( );
			hospital1.setH_name ( h_name );
			
			System.out.println ( "Enter Hospital Address: " ) ;
			String h_address=scanner.nextLine ( );
			h_address=scanner.nextLine ( );
			hospital1.setH_address ( h_address );
			
			System.out.println ( "Enter Hospital City: " ) ;
			String h_city=scanner.next( );
			hospital1.setH_city ( h_city );
			
			hosDAO.insertHos ( hospital1 );
			System.out.println ( "Data inserted..." ) ;
			break ;
		}
		
		case 2 :
		{
			System.out.println ( "Enter Id : " ) ;
			int h_id=scanner.nextInt ( );
			
			Hospital hospital2 = hosDAO.findHos ( h_id );
			
			System.out.print( "\nHospital details:\n**********************\nHospital id: "+hospital2.getH_id ( )+"\nHospital Name: " +hospital2.getH_name ( )+"\nHospital City: "+hospital2.getH_city ( )+"\nHospital Address "+hospital2.getH_address ( ) ) ;
		
			System.out.print ( "\nDoctors of hospital : " ) ;
			
			List < Doctor > doctor = hospital2.getDoctors ( );
			for(Doctor d1:doctor) 
			{
			System.out.print("\n"+d1.getD_name ( )+" " ) ;	
			}
			
			System.out.print( "\nPatients of hospital : " ) ;
			
			List < Patient > patient = hospital2.getPatients ( );
			for(Patient p1:patient) 
			{
			System.out.print("\n"+p1.getP_name ( ) ) ;	
			}
			break ;
		}
		
		case 3 :
		{
			System.out.println ( "Enter Id :" ) ;
			int h_id=scanner.nextInt ( );
			
			hosDAO.deleteHos ( h_id );
			System.out.println ( "Data removed..." ) ;
			break ;
		}
		
		case 4 :
		{
			System.out.println ("Enter id: "  ) ;
			int h_id=scanner.nextInt ( );
			
			Hospital hospital2=hosDAO.findHos ( h_id );
	
			boolean rep1=true;
			while(rep1)
	{	
			System.out.println ( "\nSelect what you want to update\n1.Name\n2.Address\n3.City\n4.Exit" ) ;
			int choice1=scanner.nextInt ( );
			
			switch ( choice1 )
	{
			case 1 :
			{
				System.out.println ( "Enter new Name: " ) ;
				String h_name=scanner.next ( );
				
				hospital2.setH_name ( h_name );
				
				hosDAO.updateHos ( hospital2 );
				break;
			}
			case 2 :
			{
				System.out.println ( "Enter new Address: " ) ;
				String h_address=scanner.next( );
				
				hospital2.setH_address ( h_address );
				
				hosDAO.updateHos ( hospital2 );
				break;
			}
			case 3 :
			{
				System.out.println ( "Enter new City: " ) ;
				String h_city=scanner.next ( );
				
				hospital2.setH_city ( h_city );
				
				hosDAO.updateHos ( hospital2);
				break;
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