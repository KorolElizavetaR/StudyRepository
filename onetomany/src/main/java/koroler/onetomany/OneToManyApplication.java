package koroler.onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import koroler.onetomany.models.*;

public class OneToManyApplication {

	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Product.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try
		{
			//PrintPeopleAndTheirItems(session);
			// AddOwnerToExistingItem(session);
			// CreatePersonAndProduct(session);
			RemovePersonOrders (session);
		}
		finally {
			session.close();	
		}
	}

	public static void PrintPeopleAndTheirItems(Session session)
	{
		Transaction transaction = session.beginTransaction();
		List <Person> people = session.createQuery("from Person").getResultList();
		for (Person person: people)
		{
			System.out.print("\n" + person.getFull_name() + ": ");
			List <Product> products = person.getProducts();
			for (Product product: products)
				System.out.print(product.getProduct_name() + " ");
		}
		transaction.commit();
	}
	
	public static void AddOwnerToExistingItem(Session session)
	{
		Transaction transaction = session.beginTransaction();
		Person person = session.get(Person.class, 10002);
		Product product = session.get(Product.class, 7);
		product.setCustomer(person);
		person.addProduct(product); // двусторонняя связь желательна, но не обязательно. не создает sql запрос
		transaction.commit();
	}
	
	public static void CreatePersonAndProduct(Session session)
	{
		Transaction transaction = session.beginTransaction();
		Person person = new Person("Баштык Сергей Сергеевич", 23);
		Product product = new Product("Стол", person);
		person.addProduct(product); // не создает sql запрос
		session.persist(person);
		session.persist(product);
		transaction.commit();
	}
	
	public static void RemovePersonOrders(Session session)
	{
		Transaction transaction = session.beginTransaction();
		Person person = session.get(Person.class, 10001);
		List<Product>products = person.getProducts();
			for (Product product: products)
				product.setCustomer(null);
		person.getProducts().clear();
		transaction.commit();
	}
	
}
