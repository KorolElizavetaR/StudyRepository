package koroler.manytomany.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Getter
@Setter
public class Movie {
	@Id
	@Column(name = "movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "movie_name")
	private String movie_name;
	
	@ManyToMany(mappedBy = "movies")
	private List <Actor> actors;
	
	public Movie(String movie_name)
	{
		actors = new ArrayList<Actor>();
		this.movie_name = movie_name;
	}
	
	public void addActor(Actor actor)
	{
		actors.add(actor);
		//actor.addMovie(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " " + this.movie_name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Movie movie = (Movie) obj;
		if (id != movie.id) return false;
		return movie_name != null ? movie_name.equals(movie.movie_name) : movie.movie_name == null;
	}
}
