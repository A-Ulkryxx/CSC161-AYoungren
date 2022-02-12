
public class Student extends Person
{
	protected final String[] RANK = {"Freshman", "Sophmore", "Junior", "Senior"};
	protected String status;
	protected int year;
	public Student(String name, String address, String phoneNumber, String email, int year) 
	{
		super(name, address, phoneNumber, email);
		this.year = year;
		this.status = RANK[year - 1];
	}

	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Student;" + name + ";" + address + ";" + phoneNumber + ";" + email + ";" + year + ";";
		return personInfo;
	}
	
	public String getStatus()
	{
		return status;
	}


	public void setStatus(String status) 
	{
		this.status = status;
		for (int i = 0; i < RANK.length; i++)
		{
			if(RANK[i].equals(status))
			{
				this.year = i;
			}
		}
	}

	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
		this.status = RANK[year - 1];
	}
	
	@Override
	public String toString() 
	{
		return "Student [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", status=" + status +"]";
	}

	
}
