package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Customer;

public class CustomerDao {

	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	
	public void insert(Customer customer) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(customer);
		transaction.commit();
	}
	
	public List<Customer> login(String username) {
		EntityManager manager=factory.createEntityManager();
		
		Query query=manager.createQuery("select c from Customer c where name=?1",Customer.class);
		query.setParameter(1, username);
		return query.getResultList();
	}

}
