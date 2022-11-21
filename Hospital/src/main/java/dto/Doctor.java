package dto;

import javax.persistence.Entity ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;

@Entity
public class Doctor
{
@Id
private int d_id;
private String d_name;
private long d_salary;
private String d_qualification;

@ManyToOne
@JoinColumn
Hospital hospital;

public int getD_id ( )
{
	return d_id ;
}

public void setD_id ( int d_id )
{
	this.d_id = d_id ;
}

public String getD_name ( )
{
	return d_name ;
}

public void setD_name ( String d_name )
{
	this.d_name = d_name ;
}

public long getD_salary ( )
{
	return d_salary ;
}

public void setD_salary ( long d_salary )
{
	this.d_salary = d_salary ;
}

public String getD_qualification ( )
{
	return d_qualification ;
}

public void setD_qualification ( String d_qualification )
{
	this.d_qualification = d_qualification ;
}

public Hospital getHospital ( )
{
	return hospital ;
}

public void setHospital ( Hospital hospital )
{
	this.hospital = hospital ;
}
}