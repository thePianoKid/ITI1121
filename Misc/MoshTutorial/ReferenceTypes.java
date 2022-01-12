import java.util.Date;

// Reference variables store objects and other non-primitive data types

public class ReferenceTypes {
	public static void main (String[] args) {
		byte age = 30;
		Date now = new Date(); // The new operator allocates memory
		// You must aloocate memory for every reference type
		// Date() is an instance of the Date class that is built into Java
		System.out.println(now);	
	}
}
