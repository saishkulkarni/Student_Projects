package session_management;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");

public void signup(User user)
{
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	transaction.begin();
	manager.persist(user);
	transaction.commit();
}

public User login(String email)
{
	EntityManager manager=factory.createEntityManager();
	
	return manager.find(User.class, email);
}
}
