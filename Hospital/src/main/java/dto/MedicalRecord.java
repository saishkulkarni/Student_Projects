package dto;

import javax.persistence.Entity ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;

@Entity
public class MedicalRecord
{
@Id
private int r_id;
private String r_date;
private String r_problem;

@JoinColumn
@ManyToOne
Patient patient;

public int getR_id ( )
{
	return r_id ;
}

public void setR_id ( int r_id )
{
	this.r_id = r_id ;
}

public String getR_date ( )
{
	return r_date ;
}

public void setR_date ( String r_date )
{
	this.r_date = r_date ;
}

public String getR_problem ( )
{
	return r_problem ;
}

public void setR_problem ( String r_problem )
{
	this.r_problem = r_problem ;
}

public Patient getPatient ( )
{
	return patient ;
}

public void setPatient ( Patient patient )
{
	this.patient = patient ;
}
}
