package first;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.math.BigDecimal;
//import javafx.util.Pair;



public class PersonDriver {

	public static void main(String[] args) {
		System.out.println("A1 Part 1");
		System.out.println("-----------------------------------------------");
		
		Scanner sc = null;
		Scanner kb = new Scanner(System.in);
		ArrayList<Person> list = new ArrayList<Person>();
		Person[] personArray = null;
		
		 try { 
			 System.out.print("Please enter the name of the file: ");
			 String fileName = kb.next();
			 
			 sc = new Scanner(new FileInputStream(fileName));
			 
			 kb.close();
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
		 } catch (Exception e) {
			 System.out.println("There is a problem with the data inside the input file. The program will terminate.");
			 System.exit(0);
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
		 System.out.println("\nSORTING the array by the people's LAST NAME:");
		 Stream<Person> stream3 = Arrays.stream(personArray);	 
		 stream3.forEach(System.out::println);
		  
		 System.out.println("Done SORTING\n");	 
		 System.out.print("Calculating average salary for all employees: ");
		 
		 Stream<Person> stream4 = Arrays.stream(personArray);	 
		 double avgsal = stream4.mapToDouble(e -> e.getSalary().doubleValue()).average().getAsDouble();
		 BigDecimal avgsal1 = new BigDecimal(avgsal);	
		 int totalEmployee = personArray.length;
		 System.out.print("The average salary for "+ totalEmployee +" total employees is ");
		 System.out.printf("%.2f", avgsal1);
		 System.out.println("$.");
		 
				 
		 Stream<Person> stream5 = Arrays.stream(personArray);
		 Map<String,DoubleSummaryStatistics> result = stream5.collect(Collectors.groupingBy(emp -> 
				 															emp.getSalary().doubleValue() < 25000 ? "<25000": 
				 															emp.getSalary().doubleValue() < 40000 ? "25000-40000":	
				 															emp.getSalary().doubleValue() < 70000 ? "<40000-70000":
				 																">70000",
				 															Collectors.summarizingDouble(emp -> emp.getSalary().doubleValue())));
		 
		 DoubleSummaryStatistics stats25k = result.get("<25000");
		 double avg25k = stats25k == null ? 0.0 : stats25k.getAverage();
		 System.out.print("There are "+ stats25k.getCount()+ " employees that have a salary of under 25000$ and the average salary is ");
		 System.out.printf("%.2f", avg25k);
		 System.out.println("$.");
		 
		 DoubleSummaryStatistics stats25k40k = result.get("25000-40000");
		 double avg25k40k = stats25k40k == null ? 0.0 : stats25k40k.getAverage();		 
		 System.out.print("There are "+ stats25k40k.getCount()+ " employees that have salary between 25000-40000$ and the average salary is ");
		 System.out.printf("%.2f", avg25k40k);
		 System.out.println("$.");
		 		 
		 DoubleSummaryStatistics stats40k70k = result.get("<40000-70000");
		 double avg40k70k = stats40k70k == null ? 0.0 : stats40k70k.getAverage();
		 System.out.print("There are "+ stats40k70k.getCount()+ " employees that have a salary between 40000-70000$ and the average salary is ");
		 System.out.printf("%.2f", avg40k70k);
		 System.out.println("$.");	
		 
		 DoubleSummaryStatistics stats70k = result.get(">70000");
		 double avg70k = stats70k == null ? 0.0 : stats70k.getAverage();
		 System.out.print("There are "+ stats70k.getCount()+ " employees that have a salary over 70000$ and the average salary is ");
		 System.out.printf("%.2f", avg70k);
		 System.out.println("$.");
		 	 
	}

}
