package korol.hibernateagain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import korol.hibernateagain.model.Person;

public class HibernateagainApplication {

	public static void main(String[] args) {
		Configuration conf = new Configuration().addAnnotatedClass(Person.class);
		SessionFactory sessionFactory = conf.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try
		{
			// GetEntityFromDB(session);
			// SaveEntityToDB(session);
			// UpdateEntityFromDB(session);
			// DeleteEntityFromDB(session);
			// PrintFullTable(session);
			// UpdateMakeOlder(session);
			DeleteEntitiesFromDBHQL(session);
		}
		finally
		{ sessionFactory.close();}
	}
	
	public static void GetEntityFromDB(Session session)
	{
		session.beginTransaction();
		Person human = session.get(Person.class, 1);
		System.out.println(human);
		session.getTransaction().commit();
	}
	
	public static void SaveEntityToDB(Session session)
	{
		session.beginTransaction();
		Person human = new Person("Изяслав", 23);
		session.persist(human);
		session.getTransaction().commit();
	}

	public static void UpdateEntityFromDB(Session session)
	{
		session.beginTransaction();
		Person human = session.get(Person.class, 2);
		human.setPerson_name("Наиль");
		session.getTransaction().commit();
	}
	
	public static void DeleteEntityFromDB(Session session)
	{
		session.beginTransaction();
		Person human = session.get(Person.class, 2);
		session.remove(human);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public static void PrintFullTable(Session session)
	{
		Transaction transaction = session.beginTransaction();
		List <Person> people = session.createQuery("FROM Person WHERE person_name LIKE '%та%'").getResultList();
		// FROM Person WHERE person_name LIKE '%та%'
		for (Person human:people)
			System.out.println(human);
		transaction.commit();
	}
	
	@SuppressWarnings("deprecation")
	public static void UpdateMakeOlder(Session session)
	{
		Transaction transaction = session.beginTransaction();
		session.createQuery("UPDATE Person SET age = age + 1 WHERE age = 25").executeUpdate();
		transaction.commit();
	}

	public static void DeleteEntitiesFromDBHQL(Session session)
	{
		Transaction transaction = session.beginTransaction();
		session.createQuery("DELETE Person WHERE age < 18").executeUpdate();
		transaction.commit();
	}
}
