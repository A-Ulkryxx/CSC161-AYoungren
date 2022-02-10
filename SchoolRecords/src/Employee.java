/**
 * A subclass of the Person class. 
 * The Person class contains "name", "address", "phone number", and "email".
 * This class (Employee) extends to data members of "office", "salary", and "date hired" 
 * while including the data members from the Person Class.
 * @author Austin Youngren
 *
 */
public class Employee extends Person
{
	protected String office;
	protected double salary;
	protected String dateHired;
	
	/**Employee constructor
	 * 
	 * @param name - person's name
	 * @param address - person's address
	 * @param phoneNumber - person's phone number
	 * @param email - person's email
	 * @param office - person's office number
	 * @param salary - person's salary
	 * @param dateHired - the date the person was hired
	 */
	public Employee(String name, String address, String phoneNumber, String email, String office, double salary,
			String dateHired) 
	{
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	/**
	 * Output of an Employee's data members
	 * @return personInfo - the print statement containing all data members 
	 * 						associated with an Employee Object
	 */
	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Staff - Name:" + name + ", Address: " + address + ", Phone Number:" + phoneNumber 
					+ ", Email: " + email + ", Office: " + office + ", Salary: " + salary + ", Date Hired: " + dateHired + "\n";
		return personInfo;
	}
	
	/** Returns the office associated with the Employee object
	 * 
	 * @return - the office associated with the Employee object
	 */
	public String getOffice() {
		return office;
	}

	/** Associates given office with specified Employee object
	 * 
	 * @param office - the office to be associated with Employee object
	 */
	public void setOffice(String office) {
		this.office = office;
	}

	/** Returns the salary associated with the Employee object
	 * 
	 * @return salary - the salary associated with the Employee object
	 */
	public double getSalary() {
		return salary;
	}

	/** Associates given salary with specified Employee object
	 * 
	 * @param salary - the salary to be associated with Employee object
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/** Returns the date associated with when the Employee object was hired
	 * 
	 * @return dateHired - the dated that's associated with when the Employee object was hired
	 */
	public String getDateHired() {
		return dateHired;
	}		

	/** Associates given date for specified Employee object as a hire date
	 * 
	 * @param  dateHired - the salary to be associated with Employee object
	 */
	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	/**
	 *  A print statement that displays Employee object along with all of it's data members when called by that Employee Object
	 */
	@Override
	public String toString() {
		return "Employee [office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + ", name=" + name
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
}
