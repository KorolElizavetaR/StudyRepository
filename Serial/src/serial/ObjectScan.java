package serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectScan {
	private static final String filename = "people.bin";
	
	public static void SerializePerson() throws IOException
	{
		Person person1 = new Person(0, "Bob");
		// Person person2 = new Person(1, "Tom");
		
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream outStream = new ObjectOutputStream(file);
		outStream.writeObject(person1);
		//outStream.writeObject(person2);
		
		outStream.close();
		file.close();
	}
	
	public static void DeserializePerson() throws IOException, ClassNotFoundException
	{
		FileInputStream FileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(FileIn);
        
        Person person = (Person) in.readObject();
        System.out.println(person);
	}
	
	public static void SerializeSeveralPeople() throws IOException
	{
		Person person1 = new Person(0, "Bob");
		Person person2 = new Person(1, "Tom");
		
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream outStream = new ObjectOutputStream(file);
		outStream.writeObject(person1);
		outStream.writeObject(person2);
		
		outStream.close();
		file.close();
	}
	
	public static void DeserializeSeveralPeople() throws IOException, ClassNotFoundException
	{
		FileInputStream FileIn = new FileInputStream(filename);
        ObjectInputStream inStream = new ObjectInputStream(FileIn);
        Person person1 = (Person) inStream.readObject();
        Person person2 = (Person) inStream.readObject();
		System.out.println(person1);
		System.out.println(person2);
        inStream.close();
        FileIn.close();
	}
	
	public static void SerializeArray() throws IOException
	{
		List <Person> people = new ArrayList<>();
		people.add(new Person(0, "Jon"));
		people.add(new Person(1, "Sora"));
		people.add(new Person(2, "Vlad"));
		
		FileOutputStream file = new FileOutputStream(filename);
		ObjectOutputStream outStream = new ObjectOutputStream(file);
		outStream.writeObject(people);
		
		outStream.close();
		file.close();
	}
	
	public static void DeserializeArray() throws IOException, ClassNotFoundException
	{
		FileInputStream FileIn = new FileInputStream(filename);
        ObjectInputStream inStream = new ObjectInputStream(FileIn);
        ArrayList <Person> people = null;
        people = (ArrayList<Person>) inStream.readObject();
        for (Person person: people)
        	System.out.println(person);
        inStream.close();
        FileIn.close();
	}
}
