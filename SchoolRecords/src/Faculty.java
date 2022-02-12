
public class Faculty extends Employee
{
	protected String officeHours;
	private final String[] RANK_TYPE = {"Junior", "Senior"};
	protected String rank;
	protected int rankNum;
	
	public Faculty(String name, String address, String phoneNumber, String email, String office, double salary,
			String dateHired, String officeHours, int rankNum) 
	{
		super(name, address, phoneNumber, email, office, salary, dateHired);
		this.officeHours = officeHours;
		this.rank = RANK_TYPE[rankNum -1];
		this.rankNum = rankNum;
	}

	@Override
	public String getPerson()
	{
		String personInfo;
		personInfo = "Faculty;" + name +  ";" + address + ";" + phoneNumber + ";" + email + ";" + office + ";" + salary + ";" 
						+ dateHired + ";" + officeHours + ";" + rankNum + ";";
		return personInfo;
	}
	
	public String getOfficeHours()
	{
		return officeHours;
	}

	public void setOfficeHours(String officeHours) 
	{
		this.officeHours = officeHours;
	}

	public int getRankNum()
	{
		return rankNum;
	}
	
	public void setRankNum(int rankNum)
	{
		this.rankNum = rankNum;
		this.rank = RANK_TYPE[rankNum - 1];
	}
	
	public String getRank() 
	{
		return rank;
	}

	public void setRank(String rank)
	{
		this.rank = rank;
		for (int i = 0; i < RANK_TYPE.length; i++)
		{
			if(RANK_TYPE[i].equals(rank))
			{
				this.rankNum = i;
			}
		}
	}

	@Override
	public String toString() {
		return "Faculty [officeHours=" + officeHours + ", rank=" + rank
				+ ", office=" + office + ", salary=" + salary + ", dateHired=" + dateHired + ", name=" + name
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	
}
