// The scope of a declaration of the region of the of the program with in which the entitiy declared by the 
// declaration can be referred to using a simple name 

// The scope of a parameter is its entire method

public class Lec3Part2 {
    public static void main(String[] args) {
        int i = 0; // scope of i starts
        int j = i + 1;

        // The args parameter is in main's scope
        
        if (true) {
            // the scope is defined by the curly brackets, so "a"
            // only is in the if state's scope
            int a = 0;
        }
    }

    public static void garbage() {
        // Take the following code:
        MyInteger a = new MyInteger(99);
        MyInteger b = new MyInteger(5);

        b = a;

        // Now that b is no longer pointing to MyInteger(5), it is of no
        // use to anyone; no variables are pointing to it
        // Java automatically removes objects that are not being used,
        // this process is called "garbage collection"
    }

    // x and y are in the scope of the entire Lec4 class
    private int x = 1;
    private int y = x + 1;
}