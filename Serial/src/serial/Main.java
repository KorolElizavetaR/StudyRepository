package serial;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			// ObjectScan.WritePerson();
			// ObjectScan.DeserializePerson();
			// ObjectScan.SerializeSeveralPeople();
			// ObjectScan.DeserializeSeveralPeople();
			 //ObjectScan.SerializeArray();
			ObjectScan.DeserializeArray();
		} 
		catch (IOException | ClassNotFoundException e) {e.printStackTrace();} 
		// catch (ClassNotFoundException e) {e.printStackTrace();}
	}

}
