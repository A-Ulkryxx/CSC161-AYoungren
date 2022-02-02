import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class FileWriter {

	public static void main(String[] args) //throws IOException 
	{
		File myFile = new File("filewritetest.txt");
		PrintWriter printWriter = null;
		try 
		{
			if (!myFile.exists())
			{
				if(myFile.createNewFile())
				{
					System.out.println("New file create: " + myFile.getName());
				}
			}
			printWriter = new PrintWriter(new FileOutputStream(myFile.getName(), false));
		}
		catch(Exception e) //emergency purposes when exception thrown
		{
			e.printStackTrace(); //logs the chain of events for exception
			System.exit(-1);
		}
		finally  //Alsways executes 
		{
			
		}
				// two lines will need to be moved to the "try" statement
		// printWriter = new PrintWriter(myFile.getName());
		//printWriter = new PrintWriter(new FileOutputStream(myFile.getName(), false));  // true: adds to file ----- false: overwrites file
		
		printWriter.println("The moon is full today. It is an auspicious day!");
		printWriter.println("I am feeling great today!");
		if( printWriter.checkError()) 
		{
			System.out.println("There were errors during the writing of the file " + myFile.getName());
		}
		printWriter.close();
	}

}
