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
		if(matchIndex > 1)
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
		char [] comp1;
		char [] comp2;
		
		comp1 = str1.toCharArray();
		comp2 = str2.toCharArray();
		for(int i = 0; i < comp2.length; i++) //Complexity possibility of O(n^2)
		{
			for(int j = 0; j < comp1.length; j++ )
			{
				if(comp1[j] == (comp2[i]))
				{
					return j;
				}
			} 
		}
		
		return -1;
	}
}
