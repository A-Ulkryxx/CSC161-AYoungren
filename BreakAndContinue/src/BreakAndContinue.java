
public class BreakAndContinue {

	public static void main(String[] args) {
		
			//Lazy use of  - DO NOT USE IN THIS FASHION
		for(int i = 0; i < 10;i++)
		{
			if (i == 4) {
				break;
			}
			System.out.println("Bottom of iteration #: " + i);
		}
		
			// Also lazy- DO NOT USE IN THIS FASHION
		for(int i = 0;i < 4; i++)
		{
			System.out.println("Bottom of iteration #: " + i);
		}
		
			//Need to do part of iteration before exiting you can use break.
			//Be careful, do everything that the program needs before breaking out
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Top of iteration #; " + i);
			if (i == 4)
			{
				break;
			}
			System.out.println("Bottom of iteratio #: " + i);
		}
		
			//Continue statement
		for(int i = 0; i < 10; i++)
		{
			if ( i == 4) 
			{
				continue;		//skips print statement on iteration 4
			}
			System.out.println("Bottom of iteration #: " + i);
		
		}
		
			//Need to skip part of the iteration
		for(int i = 0; i < 10 ; i++)
		{
			System.out.print("Top of oteration #; " + i);
			if (i == 4)
			{
				continue;
			}
			System.out.println("Bottom of iteration #: " + i);
		}
		
			// You can use break and continue in any kind of loop
			// Example of bad code that does not do everything it needs to before the continue
		int i = 0;
		
		while(i < 10)
		{
			System.out.println("Top of iteration #: " + i);
			if (i == 4)
			{
					//i++ would also need to go here
				continue;
			}
			System.out.println("Bottom of iteration #: " + i);
			i++;
		}
		
			//Only prints odd numbers
			//Continue is very useful in an enhanced for loop
		int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int element: arr)
		{
			if((element % 2) == 0)
			{
				continue;
			}
			System.out.println("Value is: " + element);
		}
	}
}
