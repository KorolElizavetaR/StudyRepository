package koroler.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import koroler.onetoone.models.*;

public class OneToManyApplication {

	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = null;
		try
		{
			transaction = session.beginTransaction();
			//SavePassportAndPerson(session);
			GetPassportFromPerson(session);
			transaction.commit();
		}
		finally {
			session.close();	
		}
	}
	
	public static void SavePassportAndPerson(Session session)
	{
		Person person = new Person("Степанюк Виктор Олегович");
		Passport passport = new Passport(person);
		person.setPassport(passport); // этот код можно и не писать
		session.persist(person);
	}
	
	public static void GetPersonFromPassport(Session session)
	{
		Person person = session.get(Person.class, 3);
		System.out.println(person.getFull_name() + " : " + person.getPassport().getPassport_id());
	}
	
	public static void GetPassportFromPerson(Session session)
	{
		Passport passport = session.get(Passport.class, 3);
		System.out.println(passport.getPerson_id().getFull_name() + " : " + passport.getPassport_id());
	}
}
