package koroler.manytomany.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "actor")
@NoArgsConstructor
@Getter
@Setter
public class Actor {
	@Id
	@Column(name = "actor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name = "full_name")
	private String full_name;
	
	@ManyToMany (cascade = { CascadeType.ALL })
	@JoinTable(
			name = "actor_movie",
			joinColumns = {@JoinColumn(name = "actor_id")},
			inverseJoinColumns = {@JoinColumn(name = "movie_id")}
			)
	private List <Movie> movies;
	
	public Actor(String full_name)
	{
		movies = new ArrayList<Movie>();
		this.full_name = full_name;	
	}
	
	public void addMovie(Movie movie)
	{
		movies.add(movie);
		//movie.addActor(this);
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.full_name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Actor actor = (Actor) obj;
		if (id != actor.id) return false;
		return full_name != null ? full_name.equals(actor.full_name) : actor.full_name == null;
	}
}
