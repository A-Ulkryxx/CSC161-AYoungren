import java.io.File;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {
		File readFile = null;
		Scanner input = null;
		
		try {
			readFile = new File("SampleInput");
			input = new Scanner(readFile);
			int[] myNumber = new int[10];
			System.out.println(myNumber[10]); // --error!
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong.");
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			System.out.println("Executed Finally");
		}
		
		while(input.hasNextLine())
		{
			String line = input.nextLine();
			System.out.println(line);
		}
		input.close();
		//readFile.delete();

	}

}
