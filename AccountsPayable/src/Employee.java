
public class Employee
{

	protected String firstName;
	protected String lastName;
	protected long socialSecNum;
	
	public Employee()
	{
		firstName = "First Name";
		lastName = "Last Name";
		socialSecNum = 123456789;
	}

	public Employee(String firstName, String lastName, long socialSecNum) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecNum = socialSecNum;
	}
	
	
	public double getPaymentAmount()
	{
		double amount = 0;
		
		return amount;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public long getSocialSecNum() 
	{
		return socialSecNum;
	}

	public void setSocialSecNum(long socialSecNum) 
	{
		this.socialSecNum = socialSecNum;
	}

	@Override
	public String toString() 
	{
		return "Employee\nFirst Name = " + firstName + ",\nLast Name = " + lastName + ",\nSocial =" + socialSecNum + "\n";
	}
	
	
}
