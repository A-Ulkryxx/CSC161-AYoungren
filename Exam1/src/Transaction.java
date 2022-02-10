import java.time.LocalDate;

public class Transaction {
	private LocalDate dateCreated = LocalDate.now();
	private char transactionType;
	private double transactionAmount;
	private double newBalanceAmount;
	
	public Transaction(char transactionType, double transactionAmount, double newBalanceAmount) 
	{
		this.dateCreated = LocalDate.now();
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.newBalanceAmount = newBalanceAmount;
	}

	public String getTransaction()
	{
		return "Transaction: Date Created - " + dateCreated + ", Transaction Type - " + transactionType
				+ ", Transaction Amount - " + transactionAmount + ", New Balance Amount: " + newBalanceAmount + "\n";
	}
	
	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public char getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(char transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public double getNewBalanceAmount() {
		return newBalanceAmount;
	}

	public void setNewBalanceAmount(double newBalanceAmount) {
		this.newBalanceAmount = newBalanceAmount;
	}

	@Override
	public String toString() {
		return "Transaction [dateCreated=" + dateCreated + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", newBalanceAmount=" + newBalanceAmount + "]";
	}
	
	
	
	
	
}
