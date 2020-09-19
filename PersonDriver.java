package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;

public class PersonDriver {

	public static void main(String[] args) {
		System.out.println("A1 Part 1");
		System.out.println("-----------------------------------------------");
		
		Scanner sc = null;
		Scanner kb = new Scanner(System.in);
		ArrayList<Person> list = new ArrayList<Person>();
		Person[] personArray = null;
		
		 try { 
			 sc = new Scanner(new FileInputStream("data.txt"));
			 
			 // reading info from file as strings, instantiating a Person, then adding to array list
			 while (sc.hasNext()) {
				 String personInfo = sc.nextLine();
				 Person person = Employee.parse(personInfo);
				 list.add(person); 		
			 }
			 	 
			 // Convert the ArrayList to Array for easier sorting
			 personArray = new Person[list.size()];
			 list.toArray(personArray);
		 
		 } catch (FileNotFoundException e) {
			 System.out.println("Could not open the input file for reading");
			 System.exit(0);
			 //CAN ADD ANOTHER EXCEPTION WHEN THE INFO FROM THE FILE THAT WE'RE READING IS SHIT
		 }
		 		 
		 // Sorting the array by the people's ID
		 Arrays.sort(personArray, (a,b) -> (""+a.getID()).compareTo(b.getID()));
		 
		 // Creating a stream to display the sorted array
		 System.out.println("\nSORTING the array by the people's ID:");
		 Stream<Person> stream1 = Arrays.stream(personArray);
		 stream1.forEach(System.out::println);
		 
		 //Sorting the array by the people's first name
		 Arrays.sort(personArray, (a,b) -> (""+a.getFirstName()).compareTo(""+b.getFirstName()));
		 // Creating a stream to display the sorted array
		 System.out.println("\nSORTING the array by the people's FIRST NAME:");
		 Stream<Person> stream2 = Arrays.stream(personArray);
		 stream2.forEach(System.out::println);
		 
		 
		 // Sorting the array by the people's last name, if they have the same last name, sort by their first name
		 Arrays.sort(personArray, (a,b) -> {
			 int ck = (""+a.getLastName()).compareTo(""+b.getLastName());
			 return ck != 0? ck:
				 (""+a.getFirstName()).compareTo(""+b.getFirstName());
		 });
		 // Creating a stream to display the sorted array
		 System.out.println("\nSORTING the array by the people's FIRST NAME:");
		 Stream<Person> stream3 = Arrays.stream(personArray);
		 stream3.forEach(System.out::println);
		  
		 System.out.println("\n");
		 System.out.println("Done");
		
	}

}
