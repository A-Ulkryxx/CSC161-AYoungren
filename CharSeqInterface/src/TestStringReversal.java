import java.util.Scanner;

public class TestStringReversal {

	public static void main(String[] args) 
	{
		Scanner input;
		input = new Scanner(System.in);
		String chosenString;
		
		System.out.println("What String would you like to use?");
		chosenString = input.nextLine();
		
		StringReverser myReversedString = new StringReverser(chosenString);
		System.out.println("The string in reverse is: " + myReversedString.revString);
		System.out.println("The string in reverse is: " + myReversedString.toString());
		System.out.println("The reverse string length is: " + myReversedString.length());
		System.out.println("The first letter of your string is: " + myReversedString.charAt(0));
		System.out.println("The third letter of your string is: " + myReversedString.charAt(2));
		System.out.println("Reversed Statement's letters in spot 2, 3, and 4 are : " + myReversedString.subSequence(1, 4));
		System.out.println("Reversed Statement's letters in spot 4, 5, and 6 are: " + myReversedString.subSequence(3, 6));
		
		input.close();
	}

}
