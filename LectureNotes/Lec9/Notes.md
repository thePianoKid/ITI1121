# Lecture 9 Notes 
> Watch video on abstract data types

## Data Types

A data types is characterized by
- A set of values
- A set of operations
- A data representation

### Abstract Data Types

An abstract data type (ADT) is characterized by
- A set of values
- A set of operations

> For the second assignment, you will utilize the Queue interface

```java
public interface Queue {
    public abstract boolean isEmpty();
    // Adds an Object to the front of the "queue"
    public abstract Object dequeue(); 
    // Removes the first Object from the "queue"
    public abstract Object enqueue();
}
```

## The Object Class

The Object class is the class that ALL classes in Java inherit from.

```java
public class Object {
    // Not covered in this class
    public abstract clone();
    // This class is often overriden by class that inherit from Object
    public abstract equals();
    // Not covered in this class
    public abstract getClass();
    // This class returns a string representation of the instantiated class and is often overriden
    public abstract toString();
    
}
```

Default implementation of `equals` method:

```java
public class Object {
    public class boolean equals(other) {
        // Not very useful
        return this == other; 
    }
}
```

> Important note: Before maniputlating objects, first check if they are `null`

## Overriding the equals() Method

The correctly override the `equals()` method, use the following rules of thumb:
- Test if the other object is not `null`
- Test if the other object is an instance of or inherits from the same class
    - Use the `instanceof` keyword. 

Example:
```java

// Test whether the other object inherit from the parent class of Shape
if (!(other instanceof Shape)) {
    return -1;
}
```