package korol.hibernateagain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import korol.hibernateagain.model.person;

public class HibernateagainApplication {

	public static void main(String[] args) {
		Configuration conf = new Configuration().addAnnotatedClass(person.class);
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try
		{
		session.beginTransaction();
		person human = session.get(person.class, 1);
		System.out.println(human);
		session.getTransaction().commit();
		}
		finally
		{ sessionFactory.close();}
	}

}
