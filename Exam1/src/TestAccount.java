
public abstract class TestAccount {

	public static void main(String[] args) 
	{
		Account account = new Account(1122, 20000, 4.5);
		Account account2 = new Account("George", 1122, 1000, 1.5);
		
		account.withdraw(2500);
		System.out.println(account.getBalance());
		account.deposit(3000);
		System.out.println(account.getBalance());
		System.out.println(account.getAccountInfo());
		
		System.out.println("Account: " + account.getId() + "\n Balance: " + account.getBalance() + "\n Monthly Interest: " + account.getMonthlyInterest() 
							+ "\n Date the account was created "+account.getdateCreated());
		System.out.println(account2.getAccountInfo());
		account2.deposit(30); 	//account2.deposit(30, "Milk Money");
		account2.deposit(40);
		account2.deposit(50);
		
		account2.withdraw(5);
		account2.withdraw(4);
		account2.withdraw(2);
		
		System.out.println(account2.getAccountInfo());
	}

}
