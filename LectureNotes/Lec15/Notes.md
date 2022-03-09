# Lecture 15

## Summery
Handling Errors
- Declaring, creating and handling exceptions
- Checked and unchecked exceptions
- Creating new exception types

## Error Processing
Erros can occur at compile-time or runtime

## Sources of Errors
- Logic of the program 
- External events: running out of memory, write error, etc

## Pre-conditions
Pre-conditions are the ensemble of conditions that the parameters and the state of the object must verify so that the computation can be successful

*From now on, try to identify the preconditions when writing a method*

## Handling Errors
Having a sentinel value is not good practice (i.e. returning -1 for a bad request)

## Exception is a Class
- *class* Throwable
    - *class* Error
        - Usually unsolvable problems
        - Ex: out of memory error
    - *class* Exception
        - Problems that could be solved within the program
        - You need to explicitly deal with exceptions

> Note: RuntimeExecption the only exception that is unchecked in Java

## Program Termination

- **When you throw any `Throwable` Object, it terminates the program abruptly**
- If uncaugth, the Exception will cause the whole stack of method calls to unwind, i.e. each method call on teh stack will terminate abruptly. If the exception is not caught the program will terminate and print a stack trace. 
- Following an exception, only the code contained in a finally clause will run

```java
public class Test {
    public static void main(String[] args) {
        System.out.println("-1-");

        throw new RuntimeException("An Exception");
        
        // This line is unreachable since RuntimeException terminates the program
        System.out.println("-1-");
    }
}
```

```java
public static void a() {
    throw new RuntimeException("An Exception");
}

public static void main(String[] args) {
    System.out.println("-1-");

    try {
        a();
    } finally {
        System.out.println("finally!");
    }
}
```

> **!!** Final exam will (probably) have a multi-choice question on exceptions

## Try-Catch Block
- In the try case, the code is monitored for exceptions
- The catch case triggers when a specific excpetion is thrown

```java
try {
    // Some code here...
} catch(exception_type1 id1) {
    // catch code here
} catch(exception_type2 id2) {
    // other catch code here...
} finally {
    // clean up code here...
}
```

### The finally Block
- If no excpetion is thrown the finally block is executed and the execution continues down after that
- If an exception is thrown and it is caught by a catch block, the corresponding catch block is executed, then the finally block is executed and the execution continues down after that
- If an exception is thrown and it is uncaught by a catch block, then the finally block is executed and the exception is thrown back to the caller

> No matter what, the finally block always runs

Conceptual example:

```java
public class Grill {
    private Burner burner = new Burner();
    public void cooking() {
        try {
            burner.on();
            addSteak();
            boolean done = false;
            while (!done) {
                done = checkSteak();
            }
        } catch (OutofGasException e1) {
            callRetailer();
        } catch (FireException e2) {
            extinguishFire();
        } finally {
            burner.off();
        }
    }
}
```

## Checked and UnChecked Exceptions
There are "checked" and "unchecked exceptions. All the the exceptions that are subclasses of `Throwable` are "unchecked" (default). Except those that are subclasses of `Exception`, those are "checked". Except those that are from a subclass of `RuntimeException`.

A method that throws a "checked exception" must declare or handle an exception.

Declaration of an exception
```java
public static void main(String[] args) throws Exception
```

> See the course GitHub page for examples of creating new exception types