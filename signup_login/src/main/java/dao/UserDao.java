package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.User;

public class UserDao
{
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");

	public void signup(User user)
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}
	
	public User login(String email)
	{
		EntityManager manager=factory.createEntityManager();
		
		return manager.find(User.class,email);
	}
	
	public List<User> loginMobile(long mobile)
	{
		EntityManager manager=factory.createEntityManager();
		
		Query query=manager.createQuery("select a from User a where mobile=?1");
		query.setParameter(1, mobile);
		
		return query.getResultList();
	}
	
	
}
