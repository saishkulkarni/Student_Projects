package com.ty.school.DTO;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;

@Entity
public class StudentDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String sname;
	private String sclass;
	private double sper;
	
	public int getSid ( )
	{
		return sid ;
	}
	public void setSid ( int sid )
	{
		this.sid = sid ;
	}
	public String getSname ( )
	{
		return sname ;
	}
	public void setSname ( String sname )
	{
		this.sname = sname ;
	}
	public String getSclass ( )
	{
		return sclass ;
	}
	public void setSclass ( String sclass )
	{
		this.sclass = sclass ;
	}
	public double getSper ( )
	{
		return sper ;
	}
	public void setSper ( double sper )
	{
		this.sper = sper ;
	}
	

}
