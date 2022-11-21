package dto;

import java.util.ArrayList ;
import java.util.List ;

import javax.persistence.Entity ;
import javax.persistence.Id ;
import javax.persistence.OneToMany ;

@Entity
public class Hospital
{
@Id
private int h_id;
private String h_name;
private String h_address;
private String h_city;

@OneToMany(mappedBy = "hospital")
List < Doctor > doctors=new ArrayList < Doctor > ( );;


@OneToMany(mappedBy = "hospital")
List < Patient > patients=new ArrayList < Patient > ( );;

public int getH_id ( )
{
	return h_id ;
}

public void setH_id ( int h_id )
{
	this.h_id = h_id ;
}

public String getH_name ( )
{
	return h_name ;
}

public void setH_name ( String h_name )
{
	this.h_name = h_name ;
}

public String getH_address ( )
{
	return h_address ;
}

public void setH_address ( String h_address )
{
	this.h_address = h_address ;
}

public String getH_city ( )
{
	return h_city ;
}

public void setH_city ( String h_city )
{
	this.h_city = h_city ;
}

public List < Doctor > getDoctors ( )
{
	return doctors ;
}

public void setDoctors ( List < Doctor > doctors )
{
	this.doctors = doctors ;
}

public List < Patient > getPatients ( )
{
	return patients ;
}

public void setPatients ( List < Patient > patients )
{
	this.patients = patients ;
}
}