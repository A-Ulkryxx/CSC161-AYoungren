
public class Staff extends Employee
{
	protected String title;

	public Staff(String name, String address, String phoneNumber, String email, String office, double salary,
			String dateHired, String title)
	{
		super(name, address, phoneNumber, email, office, salary, dateHired);
		this.title = title;
	}
	
	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Staff: Name:" + name + ", Address: " + address + ", Phone Number:" + phoneNumber 
					+ ", Email: " + email + ", Title: " + this.title + ", Office: " + office + ", Salary: "
					+ salary + ", Date Hired: " + dateHired + "\n";
		return personInfo;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Staff [title=" + title + ", office=" + office + ", salary=" + salary + ", dateHired=" + dateHired
				+ ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	
}
