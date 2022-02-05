import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;

/*
 * Create a method in Database called readDatabase. This method should read all the
persons from the PersonDatabase file and return an ArrayList of Person.
 */
public class Database
{

	private final java.io.File outFile = new File("PersonDatabase.txt");;
	private PrintWriter printWriter = null;
	private PrintWriter clearFile = null;
	void writePerson(Person person) throws IOException
	{
		
		String personData;
		try {
			
			if (!outFile.exists())
			{
				if(outFile.createNewFile())
				{
					System.out.println("New file create: " + outFile.getName());
				}
				printWriter = new PrintWriter(new FileOutputStream(outFile.getName(), false));
			}
		}
		catch(Exception e) //emergency purposes when exception thrown
		{
			e.printStackTrace(); //logs the chain of events for exception
			System.exit(-1);
		}
		
		personData = person.getPerson();
		printWriter = new PrintWriter(new FileOutputStream(outFile.getName(), true));
		printWriter.println(personData);
		
		if( printWriter.checkError()) 
		{
			System.out.println("There were errors during the writing of the file " + outFile.getName());
		}
		printWriter.close();
	}
	
	public ArrayList<String> readDatabase()
	{
		File readFile = null;
		Scanner input = null;
		ArrayList<String> dataArr = new ArrayList<String>();
		
		try {
			readFile = new File("PersonDatabase.txt");
			input = new Scanner(readFile);
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong.");
			e.printStackTrace();
			System.exit(-1);
		}
		
		while(input.hasNextLine())
		{
			dataArr.add(input.nextLine());
		}
		
		return dataArr;
	}
}
