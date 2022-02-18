import java.time.LocalDate;
import java.util.ArrayList;

public class Account 
{

		private int id;
		private double balance;
		private double annualInterestRate;
		private LocalDate dateCreated = LocalDate.now();
		private String name;
		private ArrayList<Transaction> accountTransactions= new ArrayList<Transaction>();
		
		public Account()
		{
			this.name = "Empty Account";
			this.id = 0;
			this.balance = 0;
			this.annualInterestRate = 0;
			this.dateCreated = LocalDate.now();
			
		}

		public Account(int id, double balance, double annualInterestRate)
		{
			this.id = id;
			this.balance = balance;
			this.annualInterestRate = annualInterestRate;
			this.dateCreated = LocalDate.now();
			
		}
		
		public Account(String name, int id, double balance, double annualInterestRate)
		{
			this.name = name;
			this.id = id;
			this.balance = balance;
			this.annualInterestRate = annualInterestRate;
			this.dateCreated = LocalDate.now();
			
		}
		
		public String getAccountInfo()
		{
			return "Account " + this.id + ":\n Balance - " + this.balance + "\n Annual Interest Rate - " 
					+ this.annualInterestRate + "\n Date Created - " + this.dateCreated; 
		}
		
		public double getMonthlyInterestRate()
		{
			double monthlyInterestRate;
			
			monthlyInterestRate = this.annualInterestRate  / 12;
			
			return monthlyInterestRate;
		}
		
		public double getMonthlyInterest()
		{
			double monthlyInterestRate;
			double monthlyInterest;
			
			monthlyInterestRate = (this.annualInterestRate / 100) / 12;
			monthlyInterest = this.balance * monthlyInterestRate; 
			
			return monthlyInterest;
		}
		
		public void withdraw(double amount)
		{
			Transaction newTransaction;
			newTransaction = new Transaction( 'W', amount, this.balance - amount);
			this.accountTransactions.add(newTransaction);
			this.balance = this.balance - amount;
		}
		
		public void deposit(double amount)
		{
			Transaction newTransaction;
			newTransaction = new Transaction( 'D', amount, this.balance + amount);
			this.accountTransactions.add(newTransaction);
			this.balance = this.balance + amount;
		}

		public void printSummary() {
			System.out.println(toString());
			
			for (Transaction transact: accountTransactions)
			{
				System.out.println(transact);
			}
		}
		
		public ArrayList<Transaction> getAccountTransactions() 
		{
			return accountTransactions;
		}

		public void setAccountTransactions(Transaction accountTransactions) 
		{
			this.accountTransactions.add(accountTransactions);
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}
		
		public int getId() 
		{
			return id;
		}

		public void setId(int id) 
		{
			this.id = id;
		}

		public double getBalance()
		{
			return balance;
		}

		public void setBalance(double balance) 
		{
			this.balance = balance;
		}

		public double getAnnualInterestRate() 
		{
			return annualInterestRate;
		}

		public void setAnnualInterestRate(double annualInterestRate) 
		{
			this.annualInterestRate = annualInterestRate;
		}
		
		public LocalDate getdateCreated()
		{
			return dateCreated;
		}

		@Override
		public String toString() {
			return "Account [id=" + id + ", balance=" + balance + ", annualInterestRate=" + annualInterestRate
					+ ", dateCreated=" + dateCreated + "]";
		}
		
		
}
