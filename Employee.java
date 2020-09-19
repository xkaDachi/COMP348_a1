package first;

import java.math.BigDecimal;

public class Employee implements Person{
	private String ID;
	private String firstName;
	private String lastName;
	private String salary;			//DONT KNOW IF ITS STRING
	
	// dont know if there's a constructor or not
	public Employee(String id, String f, String l, String s) {
		ID = id;
		firstName = f;
		lastName = l;
		salary = s;		
	}
	
	/**
	 * Method to set the Employee's ID
	 * @param id - Employee's ID
	 */
	public void setId(String id) {
		this.ID = id;
	}
	

	/**
	 * Method to set the Employee's Salary
	 * @param s - Employee's Salary
	 */
	public void setSalary(String s) {
		this.salary = s;
	}
	
	/**
	 * Method to set the Employee's first Name 
	 * @param f - Employee's first Name 
	 */
	public void setFirstName(String f) {
		this.firstName = f;
	}
	
	/**
	 * Method to set the Employee's last Name 
	 * @param l - Employee's last Name 
	 */
	public void setLatName(String l) {
		this.lastName = l;
	}
	
	@Override
	/**
	 * Method to access the Employee's ID
	 * @return ID - employee's id
	 */
	public String getID() {
		return ID;
	}

	@Override
	/**
	 * Method to return the Employee's first name
	 * @return firstName - Employee's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	@Override
	/**
	 * Method to return the Employee's last name
	 * @return latsName - Employee's last name
	 */
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	/**
	 * Method that will return the employee's salary in BigDecimal
	 * @return bigDecimalSalary - employee's salary in BigDecimal
	 */
	public BigDecimal getSalary() {
		BigDecimal bigDecimalSalary = new BigDecimal(salary);	
		return bigDecimalSalary;
	}
	
	/**
	 * Method to return a string of the Person's information 
	 */
	public String toString() {
		return getID() + ","+getFirstName()+","+getLastName()+","+getSalary();
	}

	
	//receive string as input
	// return an INSTANTIATED PERSON whose name id and salary is initialized with the values in the input 
	public static Person parse(String info) {
		String[] infos = info.split(",");
		Employee person = new Employee(infos[0],infos[1],infos[2],infos[3]);
		return (Person)person; 	// upcasting the employee object to type Person
	}
	
	
}
