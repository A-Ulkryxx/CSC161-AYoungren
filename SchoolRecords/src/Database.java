import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;

/** Logs person data into a text file
 * Also pulls data from text file to read into program
 * 
 * @author Austin Youngren
 */
public class Database
{
		//You said this is ok in meeting
	private File OUTFILE = new File("PersonDatabase.txt");
	private static PrintWriter printWriter = null;
	
	/**
	 * Writes person data to text file
	 * @param person - person object
	 * @throws IOException
	 */
	public void writePerson(Person person) throws IOException
	{
		
		String personData;
		try {
			
			if (!OUTFILE.exists())
			{
				if(OUTFILE.createNewFile())
				{
					System.out.println("New file create: " + OUTFILE.getName());
				}
				printWriter = new PrintWriter(new FileOutputStream(OUTFILE.getName(), false));
			}
		}
		catch(Exception e) //emergency purposes when exception thrown
		{
			e.printStackTrace(); //logs the chain of events for exception
			System.exit(-1);
		}
		
		personData = person.getPerson() + "\n";
		printWriter = new PrintWriter(new FileOutputStream(OUTFILE.getName(), true));
		printWriter.println(personData);
		
		if( printWriter.checkError()) 
		{
			System.out.println("There were errors during the writing of the file " + OUTFILE.getName());
		}
		printWriter.close();
	}
	
	/**
	 * Reads text file for person data into an Array List
	 * @return dataArr - Array list of person data
	 */
	public ArrayList<Person> readDatabase()
	{
		File readFile = null;
		Scanner input = null;
		String line;
		String[] seperation;
		ArrayList<Person> dataArr = new ArrayList<Person>();//FIXME
		Person person;
		
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
		
		while(input.hasNextLine())  //FIXME
		{
			line = input.nextLine();
			seperation = line.split(";");
			if( seperation[0].equals("Student"))
			{
				person = new Student(seperation[1], seperation[2], seperation[3], seperation[4], Integer.parseInt(seperation[5]));	
				dataArr.add(person);
			}
			else if(seperation[0].equals("Faculty"))
			{
				person = new Faculty(seperation[1], seperation[2], seperation[3], seperation[4], seperation[5], 
										Double.parseDouble(seperation[6]), seperation[7], seperation[8], Integer.parseInt(seperation[9]));
				dataArr.add(person);
			}
			else if(seperation[0].equals("Staff"))
			{
				person = new Staff(seperation[1], seperation[2], seperation[3], seperation[4], seperation[5], 
						Double.parseDouble(seperation[6]), seperation[7], seperation[8]);	
				dataArr.add(person);
			}
		}
		
		return dataArr;
	}
}
