package dto;

import java.util.ArrayList ;
import java.util.List ;

import javax.persistence.Entity ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;

@Entity
public class Patient
{
@Id
private int p_id;
private String p_name;
private String p_diagnosis;
private String p_address;

@JoinColumn
@ManyToOne
Hospital hospital;

@OneToMany(mappedBy = "patient")
List < MedicalRecord > medicalRecords=new ArrayList < MedicalRecord > ( );;

public int getP_id ( )
{
	return p_id ;
}

public void setP_id ( int p_id )
{
	this.p_id = p_id ;
}

public String getP_name ( )
{
	return p_name ;
}

public void setP_name ( String p_name )
{
	this.p_name = p_name ;
}

public String getP_diagnosis ( )
{
	return p_diagnosis ;
}

public void setP_diagnosis ( String p_diagnosis )
{
	this.p_diagnosis = p_diagnosis ;
}

public String getP_address ( )
{
	return p_address ;
}

public void setP_address ( String p_address )
{
	this.p_address = p_address ;
}

public Hospital getHospital ( )
{
	return hospital ;
}

public void setHospital ( Hospital hospital )
{
	this.hospital = hospital ;
}

public List < MedicalRecord > getMedicalRecords ( )
{
	return medicalRecords ;
}

public void setMedicalRecords ( List < MedicalRecord > medicalRecords )
{
	this.medicalRecords = medicalRecords ;
}
}
