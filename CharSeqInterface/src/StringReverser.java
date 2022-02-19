import java.io.File;

/**StringReverser Class
 * Reverses the letters of a given string and contains methods 
 * that can generate information about the String once reversed.
 * 
 * @author Austin Youngren
 *
 */
public class StringReverser implements CharSequence
{
	String revString;
	
	public StringReverser(String sentString)
	{
		revString = "";
		char[] charArray;
		int length = 0;
		charArray = sentString.toCharArray();
		for(int i = (sentString.length() - 1); i >= 0; i--)
		{
			revString = revString + charArray[i]; 
		}
	}
	
	/*Overrides length method from String class
	 * returns length of the Reversed String
	 * return: length of the string as int
	 */
	@Override
	public int length() 
	{
		char[] charArray;
		int length = 0;
		charArray = this.revString.toCharArray();
		for(char c: charArray)
		{
			length++; 
		}
		return length;
	}
	
	/*Overrides length method from String class
	 * param: index - the element of the string to be returned
	 * return: charArray[index] - the character to be returned from chosed index.
	 */
	@Override
	public char charAt(int index) 
	{
		char[] charArray;
		charArray = this.revString.toCharArray();
		return charArray[index];
	}

	/*Overrides length method from String class
	 * param: start - the first element of the string to be returned, inclusive
	 * param: end - the index after the last character of string to be returned
	 * (chosen index not included in return)
	 * return: specifiedChars - a specifed portion of the string to be returned
	 */
	@Override
	public CharSequence subSequence(int start, int end) 
	{
		char[] charArray;
		String specifiedChars = "";
		charArray = this.revString.toCharArray();
		for (int i = start; i < end; i++)
		{
			specifiedChars = specifiedChars + charArray[i];
		}
		return specifiedChars;
	}
	
	/**Overrides Object class toString method
	 * Returns the data member containing the give String reversed
	 * return: "StringReverser [revString=" + revString + "]"
	 */
	@Override
	public String toString() {
		return "StringReverser [revString=" + revString + "]";
	}
	
	
}
