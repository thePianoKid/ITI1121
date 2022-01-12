In  ITI   1121/1521,  we   use  JUnit   to  automatically   grade  the
laboratories. For  each laboratory,  we will give  you the  tests that
will be used to grade your work.

These are instructions to read and execute the tests.

We strongly believe that you can get all the information that you need
simply by reading the tests, without compiling or executing them.

For instance, the class Demo (file Demo.java) declares a method called
sum:

    public static int sum(int a, int b) {
        return a+b;
    }

The class TestDemo, declares two  tests methods for sum, testSum00 and
testSum34. Here is the source code for test34:

    @Test
    public void testSum34() {

        assertEquals(7, Demo.sum(3,4));
        
        grade += 0.25;
        
    }

As  you can  see, asserEquals  calls the  method Demo.sum  passing the
values 3 and  4. If the method  returns 7, as expected, the  test is a
success, and  the student gets  0.25 points for this  test, otherwise,
the test fails and the student gets no grade for this test.

If you would  like to compile them,  namely to make sure  that all the
names are spelled correctly, here are the instructions to do it.

These  tests require  JUnit version  4. You  will need  JUnit 4.13  or
higher. Do  NOT download version  5, as  these programs have  not been
tested with that version.

In some  cases, students will  have infinite  loops in their  code and
therefore we need  to use timeout mechanisms (do you  see why?). These
mechanisms where introduced with version 4.12 of JUnit.

In this  archive, we  have put  copies of the  two libraries  that are
needed:

https://search.maven.org/remotecontent?filepath=junit/junit/4.13/junit-4.13.jar
https://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
 
The easiest way to  compile and run the tests is  to put everything in
one folder (your source code, our tests, and the two .jar files).

> pwd

/Users/turcotte/Desktop/JUnitDemo

> ls -l

ls -l
total 896
   995 12 Jan 10:59 Demo.java
  7027 12 Jan 11:40 README-en.txt
  6239 17 Feb  2019 README-fr.txt
  3475 12 Jan 11:25 TestDemo.java
  1951 12 Jan 11:08 TestUtils.java
 45024 12 Jan 10:30 hamcrest-core-1.3.jar
381765 12 Jan 10:30 junit-4.13.jar
 
Next, you need to compile the Java files.

Under macOS, Linux, or Unix in general:
 
> javac -cp junit-4.13.jar:hamcrest-core-1.3.jar:. TestDemo.java

Under Windows:
 
> javac -cp "junit-4.13.jar;hamcrest-core-1.3.jar;." TestDemo.java

Next, we run the tests.
 
Under macOS, Linux, or Unix in general:
 
> java -cp junit-4.13.jar:hamcrest-core-1.3.jar:. TestDemo

Running TestDemo

******************************************************************
Grade for Demo (out of possible 1.0): 0.5
******************************************************************
Number of tests run: 3
Number of tests that failed: 1

List of failed tests:

testSwap(TestDemo): expected:<1> but was:<0>
	at TestDemo.testSwap(TestDemo.java:91)

Here, in this demo,  one of the three tests was  expected to fail. You
see, it tells you that assertEquals  was expecting the value 1, but it
found the value 0.

Under Windows:
 
> java -cp "junit-4.13.jar;hamcrest-core-1.3.jar;." TestDemo
******************************************************************
Grade for Demo (out of possible 1.0): 0.5
******************************************************************
Number of tests run: 3
Number of tests that failed: 1

List of failed tests:

testSwap(TestDemo): expected:<1> but was:<0>
	at TestDemo.testSwap(TestDemo.java:91)

If you  frequently compile and run  JUnit tests (for instance,  if you
would like to do  so for the laboratories), then you  can save the two
.jar files  to a location of  choice and set the  environment variable
CLASSPATH to point at them (as well as the current directory '.').
 
export CLASSPATH=/Users/turcotte/lib/java/junit-4.13/junit-4.13.jar:/Users/turcotte/lib/java/junit-4.13/hamcrest-core-1.3.jar:.

This way, you  will not need to  specify the path on  the command line
when compiling and executing tests.
 
> javac TestDemo.java
> java TestDemo

Running TestDemo

******************************************************************
Grade for Demo (out of possible 1.0): 0.5
******************************************************************
Number of tests run: 3
Number of tests that failed: 1

List of failed tests:

testSwap(TestDemo): expected:<1> but was:<0>
	at TestDemo.testSwap(TestDemo.java:91)

You can make the change permanent  by adding the export to the .bashrc
file found in  your home directory (be careful when  editing this file
as you can lock yourself out of your account if you make an error).

Likewise, on Windows  you can set the  environnment variable CLASSPATH
to designate these two .jar files.  The process is similar to what you
did in order to set the environment variable Path.

Specifically,   let's    save   a    copy   of    junit-4.13.jar   and
hamcrest-core-1.3.jar            in           the            directory
C:\Users\turcotte\Library\Java\JUnit-4.13  (adapt  this  to  your  own
environment and taste).

Next, go  to the control panel  (you can typically type  'variable' in
the Cortana search box and Windows will propose you the option to edit
the  system  environment  variables).  Define a  new  variable  called
CLASSPATH, in our  running example, the content of  the variable would
be:

"C:\Users\turcotte\Library\Java\JUnit-4.13\junit-4.13.jar;C:\Users\turcotte\Library\Java\JUnit-4.13\hamcrest-core-1.3.jar;."

Adjust the path reflect the situation on your computer.

Now, you  can compile and run  the JUnit tests without  specifying the
path of the JUnit libraries:

> javac TestDemo.java
> java TestDemo

Complementary information can be found here:
 
https://junit.org/junit4
 
We hope that this is useful to you,

Guy-Vincent, Marcel & Mehrdad

Sun Jan 12 12:33:16 2020
