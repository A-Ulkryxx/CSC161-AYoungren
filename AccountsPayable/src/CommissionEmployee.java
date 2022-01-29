/*
 * CommissionEmployee should have data members for gross sales and commission rate.
Include a constructor with parameters for all the data members.
Include accessors and mutators for the data members.
Override the getPaymentAmount() method and the toString() method to now also
print the payment amount.
The payment amount will be the gross sales x commission rate.
 */
public class CommissionEmployee extends Employee
{
	public double grossSales;
	public float commissionRate;
	
	public CommissionEmployee(double grossSales, float commissionRate, String firstName, String lastName, long socialSecNum) 
	{
		super(firstName, lastName, socialSecNum);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	@Override
	public double getPaymentAmount()
	{
		double amount = this.grossSales * this.commissionRate;
		amount = Math.round(amount*100)/100;
		return amount;
	}
	
	public double getGrossSales() 
	{
		return grossSales;
	}
	public void setGrossSales(double grossSales) 
	{
		this.grossSales = grossSales;
	}
	public double getCommissionRate() 
	{
		return commissionRate;
	}
	public void setCommissionRate(float commissionRate) 
	{
		this.commissionRate = commissionRate;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [First Name = " + firstName + ",\nLast Name = " + lastName + ",\nSocial =" + socialSecNum + 
				"\nGross Sales =" + grossSales + "\nCommission Rate =" + commissionRate + "]\n";
	}
}
