/*
 * SalariedEmployee should have a data member for weekly salary.
Include a constructor with parameters for all the data members.
Include accessors and mutators for the data member.
Override the getPaymentAmount() method and the toString() method to now also
print the payment amount.
The payment amount will be the weekly salary.

 */
public class SalariedEmployee extends Employee
{
	protected double weeklySalary;
	
	public SalariedEmployee(double payment, String firstName, String lastName, long socialSecNum)
	{
		super(firstName, lastName, socialSecNum);
		weeklySalary = payment;
	}

	@Override
	public double getPaymentAmount()
	{
		double amount = this.weeklySalary;
		
		return amount;
	}
	
	

	public double getWeeklySalary() 
	{
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) 
	{
		this.weeklySalary = weeklySalary;
	}

	@Override
	public String toString() 
	{
		return "Salaried Employee:\nFirst Name = " + firstName + ",\nLast Name = " + lastName
				 + ",\nSocial = " + socialSecNum +  "\nWeekly Salary = " + weeklySalary +"\n";
	}
	
}
