import java.io.IOException;
import java.util.ArrayList;

/*
 * In main(), create 6 persons: 2 students, 2 faculty and 2 staff. Assign values to all the
fields of the objects. You do not need to prompt a user to create these objects. Write
these objects one at a time to the PersonDatabase file using the writePerson() method
in Database.
 */
public class TestSchoolRecords 
{

	public static void main(String[] args) throws IOException 
	{
		Database rosterData = new Database();
		ArrayList<Person> dataInfo = new ArrayList<Person>();
		
		Student stud1 = new Student("Austin Youngren", "1234 Road St.", "900-800-7000", "stud1@studentemail.edu", 2 );
		Student stud2 = new Student("Mak Grettle", "4321 Street Rd.", "909-808-7007", "stud2@studentemail.edu", 4 );
								
		Faculty prof1 = new Faculty("Menezes", "8752 Sun Ct.", "200-500-9898", "prof1@school.edu", "CF-202", 35000, "7/21/2021", "11:00am - 1:00pm", 1 );
		Faculty prof2 = new Faculty("Smith", "879 Moon Ave.", "222-555-8888", "prof2@school.edu", "CM-115", 45000, "12/19/2015", "2:00pm - 4:00pm", 2 );
							
		Staff staff1 = new Staff("Overbey", "7777 Shire Blvd.", "200-888-7777", "staff1@school.edu", "FM-101", 40000, "01/06/2002", "Groundskeeper");
		Staff staff2 = new Staff("Buehler", "2020 Farmers Dr.", "909-200-5050", "staff2@school.edu", "FM-120", 30000, "6/22/2016", "Custodian");
		
		rosterData.writePerson(stud1);
		rosterData.writePerson(stud2);
		rosterData.writePerson(prof1);
		rosterData.writePerson(prof2);
		rosterData.writePerson(staff1);
		rosterData.writePerson(staff2);
		
		
		dataInfo = rosterData.readDatabase();
		
		for(Person roster: dataInfo)
		{
			System.out.println(roster.toString());
		}
	}
}
