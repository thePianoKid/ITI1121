// Lab 1 is due Tuesday, the 25th of January
// The lab sessions are all the same: you are allowed to go to any of them
// Continue work on the assignment!!

// Going from a primitive data type to an object is called "boxing"
// Going from an object to a primitve data is called "unboxing"

// Example:
// Integer i = 1;
// i = Integer.valueOf(i.intValue() + 5);
// The intValue() method unboxes the Integer object so we can perform addition on it
// The valueOf() method boxes up the integer data type

// Boxing primitive types is very inefficient, so only use wrappers when you have a good reason to

// String s = "Time elapsed: " + (55 - 34); 
// Java boxes the integer and converts it to a class 

// long time = System.currentTimeMillis();
// System.crrentTimeMillis() returns the number of milliseconds elapsed since midnight, Jan 1, 1970 UTC

// Comparision operators
// See GoodNotes for memory diagrams

public class Lec3 {
	public static void main(String[] args) {
		MyInteger a = new MyInteger(5);
		MyInteger b = new MyInteger(5);

		if (a.equals(b)) {
			System.out.println("a == b");
		}	
	}
	// It is not good practice to say a.value === b.value in an if statement
	// It is better to make a separate file and define equals explicitly

	// A formal parameter is a variable which is part of the definition of the method; it can be seen as a local variable of the body of the method
	public static int sum (int a, int b) {
		return a + b;
	} 

	// An actual parameter is the variable which is used when the method is called to supply the value for the formal parameter
	// Exmaple:
	// int midtermGrade, finalGrade;
	// sum(midtermGrade, finalGrade)

	// midtermGrade and finalGrade are actual parameters while a and b are formal parameters
 
}

