import java.util.Scanner;

public class ContainsSubstring {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s1;
		String s2;
		int matchIndex; 
		
		System.out.println("What is the first String to be compared?");
		s1 = input.nextLine();
		System.out.println("What is the second String to be compared?");
		s2 = input.nextLine();
		matchIndex = compareSub(s1, s2);
		if(matchIndex > 0)
		{
		System.out.println("String \"" + s1 + "\" and String \"" + s2 + "\" match at index: " + matchIndex);
		}
		else
		{
			System.out.println("No matching characters of the string.");
		}
		input.close();
	}


	public static int compareSub(String str1, String str2)
	{
		char [] comp1 = str1.toCharArray();
		char [] comp2 = str2.toCharArray();
		int j = 0;
		int i = 0;
		for(; i < comp1.length; i++) 
		{
			if(j == comp2.length)
			{
				return -1;
			}
			if(( comp1[i] == comp2[j]) && ( comp1[i + (comp2.length - 1)] == comp2[comp2.length - 1] ) )
			{
				return i;
			}
			if(i == (comp1.length - 1))
			{
				i = 0;
				j++;
			}
			 
		}
		
		return -1;
	}
}
