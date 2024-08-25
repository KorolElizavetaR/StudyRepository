package koroler.hibernate;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import koroler.hibernate.models.*;

public class HibernateApplication {

	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		try (sessionFactory)
		{
			LoadingAfterSession(sessionFactory);
		}
	}
	
	public static void LoadingInSession(SessionFactory sessionFactory) {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Person person = session.get(Person.class, 10002);
		System.out.println(person);
		Hibernate.initialize(person.getProducts()); //!!Подгрузка
		
		transaction.commit();
		
		//получаем товары вне сессии
		System.out.println(person.getProducts());
	}
	
	public static void LoadingAfterSession(SessionFactory sessionFactory) {
		// 1 ТРАНЗАКЦИЯ
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		Person person = session.get(Person.class, 10002);
		System.out.println(person);
		transaction.commit(); // автоматически session.close()
		// 2 ТРАНЗАКЦИЯ
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		// Объект отвязан от сессии
		person = (Person) session.merge(person); // пристегивает объект к текущей сессии
		
		//ИЛИ можно использовать HQL-запрос. Тогда вместо строки выше пишем строку ниже
		//List<Product> prod = session.createQuery("from Product where customer.person_id=:personid", Product.class).setParameter("personid", person.getPerson_id()).getResultList();
		
		// System.out.println(person.getProducts()); -- подгрузочка
		transaction.commit();
		
		//получаем товары вне сессии - теперь можно
		System.out.println(prod);
	}
	
}
