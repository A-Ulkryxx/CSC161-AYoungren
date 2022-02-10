
public class SavingsAccount extends Account 
{

	public SavingsAccount()
	{
		super();
	}
	
	public SavingsAccount(int id, double balance, double annualInterestRate)
	{
		super(id, balance, annualInterestRate);
	}

	public SavingsAccount(String name, int id, double balance, double annualInterestRate,double overdraftLimit)
	{
		super(name, id, balance, annualInterestRate);
	
	}
	@Override
	public void withdraw(double amount)
	{
		Transaction newTransaction;
		newTransaction = new Transaction( 'W', amount, this.getBalance() - amount);
		if ((this.getBalance() - amount) <= 0)
		{
			System.out.println("The withdraw amount extends your account Balance.");
			newTransaction = new Transaction( 'W', 0, this.getBalance());
		}
		else
		{
			this.setBalance(this.getBalance() - amount);
			this.setAccountTransactions(newTransaction);
		}
	}
	
	@Override
	public void deposit(double amount)
	{
		Transaction newTransaction;
		newTransaction = new Transaction( 'D', amount, this.getBalance() + amount);
		this.setAccountTransactions(newTransaction);;
		this.setBalance(this.getBalance() + amount);
	}

	
	@Override
	public String toString() {
		return "SavingsAccount [getId()=" + getId() + ", getBalance()=" + getBalance() + ", getAnnualInterestRate()="
				+ getAnnualInterestRate() + ", getdateCreated()=" + getdateCreated() + "]";
	}
}
