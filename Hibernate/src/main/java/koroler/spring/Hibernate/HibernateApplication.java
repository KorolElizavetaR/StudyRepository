package koroler.spring.Hibernate;
import koroler.spring.Hibernate.entity.StudentGroup;
import koroler.spring.Hibernate.entity.Students;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(StudentGroup.class).addAnnotatedClass(Students.class).buildSessionFactory();
		
		try {
		Session session = factory.openSession();
//		Students student = new Students("Агатов", "3523", 
//				new GregorianCalendar(2004, Calendar.MARCH, 21), 
//				new GregorianCalendar(2020, Calendar.SEPTEMBER, 1));
		session.beginTransaction();
		List <StudentGroup> st = session.createQuery("from StudentGroup where faculty = 'ИЭФ'").getResultList();
		
		for (StudentGroup studG: st)
		{
			System.out.println(studG);
		}
	//	Students student = session.get(Students.class, 280);
		//session.persist(student);
		session.getTransaction().commit();
	//	System.out.println(student);
		}
		finally
		{
			factory.close();
		}
	}

}
