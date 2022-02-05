
public class Student extends Person
{
	protected final String[] RANK = {"Freshman", "Sophmore", "Junior", "Senior"};
	protected String status;
	
	public Student(String name, String address, String phoneNumber, String email, int year) 
	{
		super(name, address, phoneNumber, email);
		
		this.status = RANK[year - 1];
	}

	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Student - Name: " + name + ", Address: " + address + ", Phone Number: " + phoneNumber 
				+ ", Email: " + email + " Status: " + status + "\n";
		return personInfo;
	}
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student:\nName: " + name + ",\nAddress: " + address + ",\nPhone Number: " + phoneNumber 
				+ ",\nEmail: " + email + "\nStatus: " + status + "\n";
	}

	
}
