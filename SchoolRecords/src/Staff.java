
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
		personInfo = "Staff;" + name + ";" + address + ";" + phoneNumber + ";" + email + ";" + office + ";" + salary + ";" + 
							dateHired + ";" + title + ";";
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
