import java.util.Scanner;

public class CreditCardValidationProc {

	static Scanner input;
	
	public static void main(String[] args) 
	{
		input = new Scanner(System.in);
		String inNum;
		int[] number;
		
		System.out.println("Input Credit Card Number");
		inNum = input.next();
		number = new int[inNum.length()];
		
		for(int i = 0; i < inNum.length(); i++)
		{
			number[i] = inNum.charAt(i)- '0';
		}
		
		System.out.println("Credit card validity: " + isValid(number));
//		System.out.println(getSize(number));
//		System.out.println(getPrefix(number, 4));
//		System.out.println(getPrefix(number, 17));
//		System.out.println(sumOfDoubleEvenPlace(number));
//		System.out.println(sumOfOddPlace(number));
//		System.out.println(prefixMatched(number, 37));
//		System.out.println(prefixMatched(number, 4));
	}

		//Return true if the card number is valid
	public static boolean isValid(int[] number)
	{
		return (getSize(number) >= 13 && getSize(number) <= 16) && (prefixMatched(number, 4)
		         || prefixMatched(number, 5) || prefixMatched(number, 3) || prefixMatched(number, 6))
		         && ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
		
	}
	
		//Add all single-digit numbers of valid card
	public static int sumOfDoubleEvenPlace(int[] number)
	{
		int sum = 0;
		int digValue;
		//int tester; //debug value test
		
		
		for(int i = (getSize(number)-2); i >= 0; i-=2)
		{
			//tester = getDigit(number[i] * 2); //debug value test
			digValue = getDigit(number[i] * 2);
			sum += digValue;
		}
		
		return sum;
	}
	
		//Return this number if it is a single digit, otherwise,
		//return the sum of the two digits
	public static int getDigit(int number)
	{
		int digit;
		digit = number;
		if (digit < 10)
		{
			return digit;
		}
		else
		{
			switch(digit)
			{
			case 10:
				digit = 1;
				break;
			case 12:
				digit = 3;
				break;
			case 14:
				digit = 5;
				break;
			case 16:
				digit = 7;
				break;
			case 18:
				digit = 9;
				break;
			default:
				break;
			}
		}
		return digit;
	}
	
		//Return sum of odd-place digits in number
	public static int sumOfOddPlace(int[] number)
	{
		int sum = 0;
		//int tester; //debug value test
		
		for(int i = (getSize(number)-1); i >= 0; i-=2)
		{
			//tester = number[i]; //debug value test
			sum = sum + number[i];
		}
		
		
		return sum;
	}
		//Return true if the digit 'd' is a prefix for number
	public static boolean prefixMatched(int[] number, int d)
	{
		if(getPrefix(number, d) == d )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
		//Return the number of digits in 'd'
	public static int getSize(int[] number)
	{
		int cardLength;
		//cardLength = (int) (Math.log10(number) + 1);
		cardLength = number.length;
		
		return cardLength;
	}
	
		//Return the first 'k' number of digits from number. If the
		//number of digits in number
	public static long getPrefix(int[] number, int k)
	{
		long prefixLong = 0;
		
		if (number.length > k) 
		{
			if (number[0] == 3)
			{
				if (number[1] == 7)
				{
					prefixLong = 3;
				}
				else 
				{;}
			} 
			else
			{
				prefixLong = number[0];
			}
				
		} 
		else {;}

		return prefixLong;
	}
	
}
