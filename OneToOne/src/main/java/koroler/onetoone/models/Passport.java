package koroler.onetoone.models;

import java.io.Serializable;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "passport")
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Passport implements Serializable {	
	@Id
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "person_id")
	private Person person_id;
	
	@Generated (org.hibernate.annotations.GenerationTime.ALWAYS)
	@Column (name = "passport_id", insertable = false)
	// @GeneratedValue (strategy = GenerationType.AUTO)
	private Integer passport_id;
	
	public Passport(Person person_id)
	{
		this.person_id = person_id;
	}
}
