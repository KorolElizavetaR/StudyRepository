package koroler.manytomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import koroler.manytomany.models.*;

public class ManyToManyApplication {

	public static void main(String[] args) {
		Configuration config = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie.class);
		SessionFactory sessionFactory = config.buildSessionFactory();
		try (sessionFactory)
		{
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			// AddActorsAndMovies(session);
			// GetActorsByMovie(session);
			DeleteFilmFromActor(session);
			transaction.commit();
		}
	}
	
	public static void AddActorsAndMovies(Session session) {
		Movie movie = new Movie("Боец");
		Actor actor = new Actor("Марк Уолберг");
		
		actor.addMovie(movie);
		Actor ChristianBale = session.get(Actor.class, 3);
		ChristianBale.addMovie(movie);
		
		session.persist(movie);
		session.persist(actor);
	}
	
	public static void GetActorsByMovie(Session session) {
		Movie movie = session.get(Movie.class, 1);
		System.out.println(movie.getMovie_name());
		List<Actor>actors = movie.getActors();
		for (Actor actor: actors)
			System.out.println(actor);
	}
	
	public static void DeleteFilmFromActor(Session session) {
		Actor MarcusChong = session.get(Actor.class, 2);
		Movie movieToRemove = session.get(Movie.class, 1);
		System.out.println(MarcusChong.getMovies().remove(movieToRemove)); 
		System.out.println(movieToRemove.getActors().remove(MarcusChong));
	}
}
