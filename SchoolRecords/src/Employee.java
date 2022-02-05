
public class Employee extends Person
{
	protected String office;
	protected double salary;
	protected String dateHired;
	
	public Employee(String name, String address, String phoneNumber, String email, String office, double salary,
			String dateHired) 
	{
		super(name, address, phoneNumber, email);
		this.office = office;
		this.salary = salary;
		this.dateHired = dateHired;
	}

	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Staff - Name:" + name + ", Address: " + address + ", Phone Number:" + phoneNumber 
					+ ", Email: " + email + ", Office: " + office + ", Salary: " + salary + ", Date Hired: " + dateHired + "\n";
		return personInfo;
	}
	
	
	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDateHired() {
		return dateHired;
	}

	public void setDateHired(String dateHired) {
		this.dateHired = dateHired;
	}

	@Override
	public String toString() {
		return "Employee [office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + ", name=" + name
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
}
