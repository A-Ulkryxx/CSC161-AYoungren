/*
 * Add a new class BasePlusCommissionEmployee. This class inherits from
CommissionEmployee and has a data member for base pay.
Include a constructor with parameters for all the data members.
Include setters and getters for the data members.
Override the getPaymentAmount() method and the toString() method to now also
print the payment amount.
The payment amount will be the base salary + commission.
The commission will have to come from the parent class. You may need to use the
super class.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {

	protected double basePay;
	
	public BasePlusCommissionEmployee(double grossSales, float commissionRate, double base, String firstName, String lastName, long socialSecNum) 
	{
		super(grossSales, commissionRate, firstName, lastName, socialSecNum);
		this.basePay = base;
	}

	@Override
	public double getPaymentAmount()
	{
		double amount = this.basePay + (this.grossSales * this.commissionRate);
		double roundAmount;
		roundAmount = Math.round(amount*100)/100;
		return roundAmount;
	}
	
	public double getBasePay() 
	{
		return basePay;
	}

	public void setBasePay(double basePay) 
	{
		this.basePay = basePay;
	}

	@Override
	public String toString() {
		return  "BasePlusCommissionEmployee:\nFirst Name = " + firstName + ",\nLast Name = " + lastName + ",\nSocial = "+ socialSecNum + 
				"\nBasePay = " + basePay + ",\nGross Sales = " + grossSales + ",\nCommission Rate = "+ commissionRate  + "\n";
	}

	
}
