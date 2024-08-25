package koroler.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import koroler.onetoone.models.*;

public class OneToManyApplication {

	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try
		{
			
		}
		finally {
			session.close();	
		}
	}

	
}
