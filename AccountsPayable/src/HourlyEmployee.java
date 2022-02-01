/*
 * HourlyEmployee should have data members for hourly wage and hours.
Include a constructor with parameters for all the data members.
Include accessors and mutators for the data member.
Override the getPaymentAmount() method and the toString() method to now also 
print the payment amount.
The payment amount will be the hourly wage x hours.

 */
public class HourlyEmployee extends Employee
{
	protected double hourlyWage;
	protected float hours;
	
	public HourlyEmployee(double hourlyWage, float hours, String firstName, String lastName, long socialSecNum) 
	{
		super(firstName, lastName, socialSecNum);
		this.hourlyWage = hourlyWage;
		this.hours = hours;
	}

	@Override
	public double getPaymentAmount()
	{
		double amount = this.hourlyWage * this.hours;
		
		return amount;
	}
	
	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}
	
	@Override
	public String toString()
	{
		return "Hourly Employee:\nFirst Name = " + firstName + ",\nLast Name = " + lastName + ",\nSocial = " + socialSecNum + "\nHours = " 
				+ hours + "\nHourly Wage = " + hourlyWage + "\nPayment Amount = " + (hourlyWage * hours) +"\n";
	}

}
