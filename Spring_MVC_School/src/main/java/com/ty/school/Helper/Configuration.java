package com.ty.school.Helper ;

import javax.persistence.EntityManagerFactory ;
import javax.persistence.Persistence ;

import org.springframework.context.annotation.Bean ;
import org.springframework.context.annotation.ComponentScan ;

@ org.springframework.context.annotation.Configuration
@ ComponentScan ( basePackages = "com.ty" )
public class Configuration
{
	@ Bean
	public EntityManagerFactory entityManagerFactory ( )
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ( "dev" ) ;
		return entityManagerFactory ;
	}
}
