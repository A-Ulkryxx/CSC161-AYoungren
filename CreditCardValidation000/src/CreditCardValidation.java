
public class CreditCardValidation 
{

	private int[] number;

	public CreditCardValidation(String inNum) 
	{
		number = new int[inNum.length()];

		for (int i = 0; i < inNum.length(); i++) 
		{
			number[i] = inNum.charAt(i) - '0';
		}
	}

		// Return true if the card number is valid
	public boolean isValid()
	{
		return (getSize() >= 13 && getSize() <= 16)
				&& (prefixMatched(4) || prefixMatched(5) || prefixMatched(3) || prefixMatched(6))
				&& ((sumOfDoubleEvenPlace() + sumOfOddPlace()) % 10 == 0);
	}

		// Add all single-digit numbers of valid card
	private int sumOfDoubleEvenPlace() 
	{
		int sum = 0;
		int digValue;
		// int tester; //debug value test

		for (int i = (getSize() - 2); i >= 0; i -= 2) 
		{
			// tester = getDigit(number[i] * 2); //debug value test
			digValue = getDigit(number[i] * 2);
			sum += digValue;
		}

		return sum;
	}

		// Return this number if it is a single digit, otherwise,
		// return the sum of the two digits
	private int getDigit(int number) 
	{
		int digit;
		digit = number;
		if (digit < 10) 
		{
			return digit;
		}
		else
		{
			switch (digit)
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

		// Return sum of odd-place digits in number
	private int sumOfOddPlace()
	{
		int sum = 0;
		// int tester; //debug value test

		for (int i = (getSize() - 1); i >= 0; i -= 2) 
		{
			// tester = number[i]; //debug value test
			sum = sum + number[i];
		}

		return sum;
	}

		// Return true if the digit 'd' is a prefix for number
	private boolean prefixMatched(int d)
	{
		if (getPrefix(d) == d) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

		// Return the number of digits in 'd'
	private int getSize()
	{
		int cardLength;
		// cardLength = (int) (Math.log10(number) + 1);
		cardLength = number.length;

		return cardLength;
	}

		// Return the first 'k' number of digits from number. If the
		// number of digits in number
	public long getPrefix(int k) 
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