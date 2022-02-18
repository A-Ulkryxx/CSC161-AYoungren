
public class CheckingAccount extends Account
{
	private double overdraftLimit;

	public CheckingAccount()
	{
		super();
		overdraftLimit = 100;
	}
	
	public CheckingAccount( int id, double balance, double annualInterestRate, double overdraftLimit ) 
	{
		super( id, balance, annualInterestRate);
		this.overdraftLimit = overdraftLimit;
	}
	
	public CheckingAccount(String name, int id, double balance, double annualInterestRate,double overdraftLimit)
	{
		super(name, id, balance, annualInterestRate);
		this.overdraftLimit = overdraftLimit;
	}

	public void withdraw(double amount)
	{
		Transaction newTransaction;
		newTransaction = new Transaction( 'W', amount, this.getBalance() - amount);
		
		if ((this.getBalance() - amount) < ( 0 - this.overdraftLimit))
		{
			System.out.println("The withdraw amount extends your overdraft limit.");
			newTransaction = new Transaction( 'W', 0, this.getBalance());
		}
		else
		{
			this.setAccountTransactions(newTransaction);
			this.setBalance(this.getBalance() - amount);
		}
	}
	
	public void deposit(double amount)
	{
		Transaction newTransaction;
		newTransaction = new Transaction( 'D', amount, this.getBalance() + amount);
		this.setAccountTransactions(newTransaction);;
		this.setBalance(this.getBalance() + amount);
	}

	public double getOverdraftLimit() 
	{
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) 
	{
		this.overdraftLimit = overdraftLimit;
	}


	@Override
	public String toString() {
		return "CheckingAccount [overdraftLimit=" + overdraftLimit + ", getId()=" + getId() + ", getBalance()="
				+ getBalance() + ", getAnnualInterestRate()=" + getAnnualInterestRate() + ", getdateCreated()="
				+ getdateCreated() + "]";
	}
	
	
}
