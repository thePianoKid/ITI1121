package package1;

// If there is no access keyword, the class is only available 
// to other classes in the package
public class MyInteger {
	// Only instances of Integer can see value
	// No other classes can see a private variable
    private int value;

    // If there is no access keyword, the methods are only available 
    // to other classes in the package
    public MyInteger (int value) {
    	this.value = value;
    }

    boolean equals(MyInteger other) {
    	return this.value == other.value;
    }
}
