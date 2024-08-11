package koroler.spring.HibernateBootstraped;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Query;
import koroler.spring.HibernateBootstraped.Entities.StudentGroup;
import koroler.spring.HibernateBootstraped.Entities.Students;

@SpringBootApplication
public class HibernateBootstrapedApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Students.class).
				addAnnotatedClass(StudentGroup.class).
				buildSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = null;
		try
		{
		transaction = session.beginTransaction();
		@SuppressWarnings("deprecation")
		Query query = session.createQuery("from Students");
		@SuppressWarnings("unchecked")
		List <Students> list = query.getResultList();
		for (Students element:list)
		{
			System.out.println(element);
		}
		transaction.commit();
		}
		catch(Exception ex)
		{if(transaction !=null)
	            transaction.rollback();
			ex.printStackTrace();}
			finally
		{
			session.close();
			factory.close();
		}
	}

}
