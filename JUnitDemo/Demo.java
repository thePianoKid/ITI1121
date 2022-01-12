/**
 * The class Demo has two public static methods, sum and swap. These
 * are used to illustrates how JUnit can be used to test Java
 * programs.  In particular, JUnit is used for the automated grading
 * of your laboratories.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 * @version Sun Jan 12 10:59:38 2020
 */

public class Demo {

    /**
     * The method returns the sum of the two integer values given as
     * arguments.
     * 
     * @param a the first argument
     * @param b the second argument
     * @return the sum of a and b
     */

    public static int sum(int a, int b) {
        return a+b;
    }
    
    /**
     * The method is meant the content of the first two cells of an
     * array. However, this behaviour has not been implemented yet,
     * which will cause an error when running the JUnit tests.
     * 
     * @param xs the reference of an array of integer values
     */

    public static void swap(int[] xs) {

        ;
        
    }

}
