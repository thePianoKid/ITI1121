// Code is taken from the following tutorial by Dr. Dujmovic -> https://youtu.be/T6KIW3jhuT8

import java.util.Scanner; // This is a library that is built into Java, and is used for terminal input from the user

public class HelloWorld { // This class must have the same name as the file
	public static void main(String[] args) { // The static keyword is there 
											 // so that we don't have to reference the parent class
		System.out.println("Hello World");
		
		// Data Types
		
		// ----------------------------------

		int x = 3;
		int y = 2;
		System.out.println(x/y); // This line will print 1 since both x and y are integers

		float newX = (float)x; // This operation "casts" the x as a float
		System.out.println(newX/y); // This line will print 1 since both x and y are integers		
		
		int p = (int)4.0/2; // Another example of casting
		System.out.println(p);

		System.out.println("2^10 = " + Math.pow(2, 10)); // Math is a class that is built into Java, no import is needed
	
		// ----------------------------------

		// Arrays

		// Method 1:
		int[] A = new int[6]; // Make an array with six elements, all of whom are integers
							  // The integers default to 0
		System.out.println(A); // Prints the reference to the array in the memory, not the actual array
		System.out.println(A.length); // Prints the length of the array 

		// Method 2:
		char[] L = {'a', 'b', 'c'}; // Work arround the "new" keyword

		// Loop over elements of list
		for (char c : L) { // if L was a list of integers, c would be of type int
			System.out.println(c);
		}

		// For loop with index
		for (int i = 0; i < A.length; i++) {
			System.out.println(i);
		}
		
		int[] B = {90, 88, 64};

		System.out.println(A == B); // Java does not compare the contents of A and B,
									// instead, it compares the address of the memory 
									// slot where the arrays are stored.

		// ----------------------------------

		// Strings

		String s = "This is a string!"; // No single single-quote strings
										// No multi-line string
		System.out.println(s);

		// Because Java is very object-oriented, we must use string methods on strings
		char stringSlice = s.charAt(0);
		System.out.println(stringSlice);
		// List of string methods: https://www.w3schools.com/java/java_ref_string.asp
	
		// ----------------------------------

		// Inputting

		Scanner sc = new Scanner(System.in);
		System.out.println("Input something: ");
		String userInput = sc.nextLine(); // There are different methods for different data types
										  // I.e. nextInt() 
		System.out.println("You inputed "+userInput);
		sc.close();
	}
}

// Note that Java is a staticly typed language

// This means that once you declare its type, the 
// variable must have the same type during the duration of the program.

/*
Java Types:


Primitive Data Types
--------------------

byte -> 8 bits of data -> 256 different values -> any value from -128 to 127, inclusive
short -> 16 bits -> 65536 different values -> any value from ≈-32000 to ≈32000
int -> 32 bits -> ≈-2,000,000,000 to ≈2,000,000,000
long -> for very big integers
float -> 32 bits -> approximations of real numbers
double -> 62 bits -> better approximations of real numbers
boolean -> 1 bit, true or false
char -> 16 bit -> single unicode character
reference -> a reference to an object


Comparision Operators
---------------------

*same as Python* 
==. <, >, <=, >=, !=

AND: &&
OR: ||
NOT: !
*/
