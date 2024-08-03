package koroler.spring.Hibernate;
import koroler.spring.Hibernate.entity.Exams;
import koroler.spring.Hibernate.entity.StudentGroup;
import koroler.spring.Hibernate.entity.Students;
import koroler.spring.Hibernate.entity.Subjects;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Students.class).
				addAnnotatedClass(StudentGroup.class).
				addAnnotatedClass(Exams.class).
				addAnnotatedClass(Subjects.class).
				buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = null;
		try
		{
		transaction = session.beginTransaction();
		List <Students> st = session.createQuery("from Students").getResultList();
		//List <Students> st = session.createQuery("select distinct student.last_name, AVG(score) from Exams group by student.last_name").getResultList();
		//Query query = session.createQuery("select subjects.subject_name, student.last_name, score from Exams");
		//List result = query.getResultList();
		System.out.println(st);
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
