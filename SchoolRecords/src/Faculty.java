import java.util.Arrays;

public class Faculty extends Employee
{
	protected String officeHours;
	private final String[] RANK_TYPE = {"Junior", "Senior"};
	protected String rank;
	
	public Faculty(String name, String address, String phoneNumber, String email, String office, double salary,
			String dateHired, String officeHours, int rankNum) 
	{
		super(name, address, phoneNumber, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = RANK_TYPE[rankNum -1];
	}

	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Faculty - Name:" + name +  ", Rank: " + rank + ", Address: " + address + ",  Phone Number:" + phoneNumber 
					+ ", Email: " + email + ", Office: " + office + ", Office Hours: " + officeHours +", Salary: " + salary 
					+ ", Date Hired: " + dateHired + "\n";
		return personInfo;
	}
	
	public String getOfficeHours() {
		return officeHours;
	}

	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Faculty [officeHours=" + officeHours + ", RANK_TYPE=" + Arrays.toString(RANK_TYPE) + ", rank=" + rank
				+ ", office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + ", name=" + name
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	
}
