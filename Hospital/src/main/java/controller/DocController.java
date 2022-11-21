package controller;

import java.util.List ;
import java.util.Scanner ;

import dao.DocDAO ;
import dao.HosDAO ;
import dto.Doctor ;
import dto.Hospital ;

public class DocController
{
static Scanner scanner=new Scanner ( System.in );
	
public static void main ( String [ ] args )
{
	DocDAO docDAO=new DocDAO ( );
	HosDAO hosDAO=new HosDAO ( );
	boolean rep=true;
	while(rep) 
	{
	System.out.print ( "\nSelect one option\n*********************\n1.Insert Record \n2.Fetch Record\n3.Delete Record\n4.Update Record\n5.Exit\n*********************\nEnter your choice: " );
	int choice = scanner.nextInt ( );
	
	switch ( choice )
{
	case 1 :
	{
		Doctor doctor1=new Doctor ( );
		
		System.out.println ( "Enter Doctor ID:" ) ;
		int d_id=scanner.nextInt ( );
		doctor1.setD_id ( d_id );
		
		System.out.println ( "Enter Doctor Name:" ) ;
		String d_name=scanner.next ( );
		doctor1.setD_name ( d_name );
		
		System.out.println ( "Enter Doctor Qualification:" ) ;
		String d_qualification=scanner.next ( );
		doctor1.setD_qualification ( d_qualification );
		
		System.out.println ( "Enter Doctor Salary:" ) ;
		long d_salary=scanner.nextLong ( );
		doctor1.setD_salary ( d_salary );
		
		System.out.println ( "Enter Hospital_id of Doctor: " ) ;
		int h_id=scanner.nextInt ( );
		
		Hospital hospital  =hosDAO.findHos ( h_id );
		if(hospital!=null)
		{
		doctor1.setHospital ( hospital );

		docDAO.insertDoc ( doctor1 );
		
		List < Doctor > list=hospital.getDoctors ( );
		list.add ( doctor1 );
		
		hospital.setDoctors ( list );
		
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
		System.out.println ( "Enter Id :" ) ;
		int d_id=scanner.nextInt ( );
		
		Doctor doctor1 = docDAO.findDoc ( d_id );
		System.out.println ( "Doctor details:\n**************\nDoctor id: "+doctor1.getD_id ( )+"\nDoctor Name: " +doctor1.getD_name ( )+"\nDoctor Salary: "+doctor1.getD_salary ( )+"\nDoctor Qualification: "+doctor1.getD_qualification ( )+"\nDoctor Hospital name: "+doctor1.getHospital ( ).getH_name ( ) ) ;
		break ;
	}
	
	case 3 :
	{
		System.out.println ( "Enter Id :" ) ;
		int d_id=scanner.nextInt ( );
		
		docDAO.deleteDoc ( d_id );
		System.out.println ( "Data removed..." ) ;
		break ;
	}
	
	case 4 :
	{
		
		System.out.println ("Enter id: "  ) ;
		int d_id=scanner.nextInt ( );
			
		Doctor doctor2=docDAO.findDoc ( d_id );
		boolean rep1=true;
		while(rep1)
{
		System.out.println ( "\nSelect what you want to update\n1.Name\n2.Salary\n3.Qualification \n4.Hospital_id\n5.Exit" ) ;
		int choice1=scanner.nextInt ( );
		
		switch ( choice1 )
{
		case 1 :
		{
			System.out.println ( "Enter new Name: " ) ;
			String d_name=scanner.next ( );
			
			doctor2.setD_name ( d_name );
			
			docDAO.updateDoc ( doctor2 );
			break;
		}
		case 2 :
		{
			System.out.println ( "Enter new Salary: " ) ;
			long sal=scanner.nextLong ( );
			
			doctor2.setD_salary ( sal );
			
			docDAO.updateDoc ( doctor2 );
			break;
		}
		case 3 :
		{
			System.out.println ( "Enter new Qualification: " ) ;
			String d_qual=scanner.next ( );
			
			doctor2.setD_qualification ( d_qual );
			
			docDAO.updateDoc ( doctor2 );
			break;
		}
		case 4 :
		{
			System.out.println ( "Enter new Hospital_id: " ) ;
			int h_id=scanner.nextInt ( );
			
			Hospital hospital1=hosDAO.findHos ( doctor2.getD_id ( ));
			hospital1.setH_id ( h_id );
			
			doctor2.setHospital ( hospital1);
			
			docDAO.updateDoc ( doctor2 );
			break;
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