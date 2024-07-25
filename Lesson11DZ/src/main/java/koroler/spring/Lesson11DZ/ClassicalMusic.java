package koroler.spring.Lesson11DZ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component ("classicalMusic")
public class ClassicalMusic implements Music{
	List <String> compositions;
	
	ClassicalMusic()
	{
		compositions = new ArrayList<String>(List.of
				("Prelude in C Major by Bach", 
				"Hungarian Rhapsody No. 2 by Franz Liszt",
				"In the Hall of the Mountain King by Edvard Grieg"));
	}
	
	@Override
	public String getSong(int id) {
		return compositions.get(id);
	}

}
