package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Product;

public class ProductDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");

	public void insert(Product product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(product);
		transaction.commit();
	}

	public List<Product> fetchProduct() {
		EntityManager manager = factory.createEntityManager();
		
		Query query=manager.createQuery("select p from Product p",Product.class);
		return query.getResultList();
	}
	
	public Product fetchProduct(int id) {
		EntityManager manager = factory.createEntityManager();
		
		return manager.find(Product.class, id);
	}
}
