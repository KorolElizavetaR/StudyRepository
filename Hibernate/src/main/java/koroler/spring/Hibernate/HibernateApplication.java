package koroler.spring.Hibernate;
import koroler.spring.Hibernate.entity.StudentGroup;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(StudentGroup.class).buildSessionFactory();
		try {
		Session session = factory.openSession();
		StudentGroup student = new StudentGroup("1233", "ФИБ");
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
