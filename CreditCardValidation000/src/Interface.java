import java.util.Scanner;

public class Interface {
	static Scanner input;
	
	public static void main(String[] args)
	{
		input = new Scanner(System.in);
		CreditCardValidation cnumber;
		String inNum;
		
		System.out.println("Input Credit Card Number");
		inNum = input.next();
		
		cnumber = new CreditCardValidation(inNum);
		
		System.out.println("Credit Card Validity: " + cnumber.isValid());
	}
}
