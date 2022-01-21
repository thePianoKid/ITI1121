public class Lec2 {
    public static void main(String[] args) {
        // Since java is a strongly typed programming language, the variable type must be decleared
        int i; 
        i = 33;

        // Data types tell the complier how much memory to allocate:
            // double: 8 bytes
            // char: 2 bytes
        // Data types also provides useful semantics I.E. what operations are allowed
        // There are two main data types: primitive and reference data types

        // Primitive data types:
        // numbers, characters (but not Strings) and booleans
        // The value is store at the memory location designated by the label of the variable

        // In java there are a fixed number of primitive data types:
            // byte
            // short
            // int
            // long
            // float
            // double
            // boolean
            // char
        // All other data types are reference data types

        // Reference data types:
        // Arrays, Strings, user defined (ex: instance of a class)
        // If it is not a primitive, then it is a reference data type!
        // When you are declaring a reference type, start with an uppercase letter
        // The value of a reference variable is a memory location which points to the location of an object

        String s; // This command only allocates space for a POINTER to a String class
        // It does not allocate space for a String class
        s = new String("Helloo"); // This allocates space for a String class

        // See the ITI 1121 GoodNotes folder for memory diagram 

        // In a memory diagram, the marker is looking for 
            // A box for every reference variable 
            // A box for every primitive variable with the value inside the box
            // A box for every object

        // See Constant.java for reference code
        // See GoodNotes for memory diagram of Constant.java

        // Wrapper classes
        // Wrapper classes transform primitive types to reference types
        // Here are examples of wrappers:

        // Primitive | Reference
        // ---------------------
        // byte      | Byte
        // short     | Short
        // int       | Integer
        // etc...

        Integer num = 1; // Note that there is no need to allocate memory using the new keyword
        // Nevertheless, this is still a reference variable
        // Line 58 is equivalent to line 61
        Integer num2 = new Integer(1); // Deprecated! 

        // Similarly, the statement 
        Integer num3 = 1;
        num3 = num3 + 5;

        // Can also be written as
        Integer num4;
        num4 = new Integer(1);
        num4 = num4.intValue() + 5;
    }
}