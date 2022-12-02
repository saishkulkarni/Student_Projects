package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Employee;

public class Dao 
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	
	public void saveEmployee(Employee employee)
	{
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	transaction.begin();
	manager.persist(employee);
	transaction.commit();
	}
	
	public List<Employee> login(String email)
	{
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery("select e from Employee e where email=?1");
		query.setParameter(1, email);
		return query.getResultList();
	}
	
	public List<Employee> fetchAll()
	{
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery("select e from Employee e");
		return query.getResultList();
	}

}
