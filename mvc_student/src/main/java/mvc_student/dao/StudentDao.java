package mvc_student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import mvc_student.dto.Student;

@Component
public class StudentDao 
{
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
EntityManager manager=factory.createEntityManager();
EntityTransaction transaction=manager.getTransaction();

public void saveStudent(Student student)
{
	transaction.begin();
	manager.persist(student);
	transaction.commit();
}

public Student fetchStudentById(int id)
{
	return manager.find(Student.class, id);
}

public List<Student> fetchAll() {
	return manager.createQuery("select x from Student x").getResultList();
}

public void removeStudent(int id) {
	transaction.begin();
	manager.remove(fetchStudentById(id));
	transaction.commit();
}

}
