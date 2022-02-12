/**A class made to create a person object with data members of
 * "name", "address", "phone number", and "email"
 * 
 * @author Austin Youngren
 *
 */
public class Person 
{
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String email;
	
	/**
	 * 
	 * @param name - The name to be associated to the person object
	 * @param address - The house address to be associated to the person object
	 * @param phoneNumber - The phone number to be associated to the person object
	 * @param email - The email to be associated to the person object
	 */
	public Person(String name, String address, String phoneNumber, String email)
	{
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	/**
	 * Output of a Person's data members
	 * @return personInfo - the print statement containing all data members 
	 * 						associated with a Person Object
	 */
	public String getPerson()
	{
		String personInfo;
		personInfo = "Person;" + name + ";" + address + ";" + phoneNumber + ";" + email + ";";
		return personInfo;
	}
	
	/**
	 * Returns the name associated with the person object
	 * @return name - the name associated with the person object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name to be associated with the person object
	 * @param name - the name to be associated with the person object
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Person: \nname:" + name + ",\naddress: " + address + ",\nphoneNumber: " + phoneNumber + ",\nemail: " + email
				+ "\n";
	}
}
