/**
 * The class TestDemo is used to illustrates how JUnit can be used to
 * test Java programs.  In particular, JUnit is used for the automated
 * grading of your laboratories in ITI 1121/1521.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 * @version Sun Jan 12 11:00:40 2020
 */

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestDemo {

    /**
     * We impose a limit on the execution time. This is to ensure that
     * tests complete rapidly even if there is an infinite loop in the
     * solution provided by the student.
     */
    
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    /**
     * This method is ran after the execution of all the tests. It
     * displays the grade for this particular series of tests.
     */
    
    @AfterClass
    public static void afterClass() {
        
        System.out.println(TestUtils.DIV);
        
        System.out.println("Grade for Demo (out of possible 1.0): " + grade);
        
        System.out.println(TestUtils.DIV);
        
    }

    /**
     * Calls the method sum with the values 0 and 0. If method returns
     * 0, as expected, then the student gets 0.25 point.
     */

    @Test
    public void testSum00() {

        assertEquals(0, Demo.sum(0,0));
        
        grade += 0.25;
        
    }
    
    /**
     * Calls the method sum with the values 3 and 7. If method returns
     * 7, as expected, then the student gets 0.25 point.
     */
    
    @Test
    public void testSum34() {

        assertEquals(7, Demo.sum(3,4));
        
        grade += 0.25;
        
    }
    
    /**
     * Calls the method swap with the reference of an array containing
     * the values 0 and 1, in that order. If the method swap was
     * implemented correctly, after a call to swap, values[0] would
     * now contain 1, whereas values[1] would contain the value 0. For
     * this demo, the method swap has not been implemented correctly
     * to illustrate what happens when a test fails.
     */
    
    @Test
    public void testSwap() {

        int[] values;
        values = new int[] {0,1};

        Demo.swap(values);

        assertEquals(1, values[0]);
        
        grade += 0.25;

        assertEquals(0, values[1]);
        
        grade += 0.25;

    }

    /**
     * This is the main method of our test. When executing "java
     * TestDemo" on the command line, the Java Virtual Machine is
     * looking for a method main.
     *
     * @param the reference of an array of strings containing all the
     * arguments passed on the command line (not used here).q
     */
    
    public static void main(String[] args) {

        TestUtils.runClass(TestDemo.class);
        
    }

}

// Expected output:
// 
// > java TestDemo
//
// Running TestDemo
// 
// ******************************************************************
// Grade for Demo (out of possible 1.0): 0.5
// ******************************************************************
// Number of tests run: 3
// Number of tests that failed: 1
// 
// List of failed tests:
// 
// testSwap(TestDemo): expected:<1> but was:<0>
// 	at TestDemo.testSwap(TestDemo.java:61)
