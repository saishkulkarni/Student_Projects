package com.ty.school.DTO;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;

@Entity
public class TeacherDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int tid;
	private String tname;
	private String tclass;
	private String tsub;

	public int getTid ( )
	{
		return tid ;
	}
	public void setTid ( int tid )
	{
		this.tid = tid ;
	}
	public String getTname ( )
	{
		return tname ;
	}
	public void setTname ( String tname )
	{
		this.tname = tname ;
	}
	public String getTclass ( )
	{
		return tclass ;
	}
	public void setTclass ( String tclass )
	{
		this.tclass = tclass ;
	}
	public String getTsub ( )
	{
		return tsub ;
	}
	public void setTsub ( String tsub )
	{
		this.tsub = tsub ;
	}

}
