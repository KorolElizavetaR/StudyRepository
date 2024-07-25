package koroler.spring.Lesson11DZ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component ("metalMusic")
public class MetalMusic implements Music{

	List <String> compositions;
	
	MetalMusic()
	{
		compositions = new ArrayList<String>(List.of
				("Hardwire by Metallica",
				"Ignite by skillet",
				"Chop Suey! by System of a Down"));
	}
	
	@Override
	public String getSong(int id) {
		return compositions.get(id);
	}

}
