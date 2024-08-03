package koroler.spring.Hibernate;
import koroler.spring.Hibernate.entity.Students;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Students.class).buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try
		{
		transaction = session.beginTransaction();
		List <Students> st = session.createQuery("from Students").getResultList();
		
		for (Students studG: st)
		{
			System.out.println(studG);
		}
		transaction.commit();}
		catch(Exception ex)
		{
			if(transaction !=null)
	            transaction.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
			factory.close();
		}

	}

}
