# Lecture 7 Notes
> Feb 2nd, 2022

## Polymorphism

From the Greek words *polus* = many and *morphe* = forms, literally means has many forms

1. Ad hoc polymorphism (overloading): a method name is associcated with different blocs of code

2. Inclusion (subtyping, data) polymorphism: a reference variable is associated with data of different types with the use of a subtype relation

The class PrintStream has a specific `println` method for each primitive type. This is a good example of overloading.

Example of method overloading:

```java
Shape() {
    x = 0.0;
    y = 0.0;
}

// It is easy to determine which variant of the Shape class will be used
Shape(int x, int y) {
    this.x = x;
    this.y = y;
}
```

Inclusion polymorphism:

Assignment of a value of compile-time reference type S (source) to a variable of compltime reference type T (target) is checked as follows:

If S is a class type:
    - If T is a class type, then S must either be in the same class as T, or S must be a subclass of T, or a compile-time error occurs.

Example:

```java
// Since Shape is the super class of a circle, we can make Shape the reference type of a Cirle reference variable
Shape c = new Circle(5, 5, 15);
```

Since you initialzed the `c` variable using Shape, you will look at `c` using the lense of Shape, none of the classes that are specific to Circle can be accessd by `c`.

Take the following Java code:

```java
public class Bird() {
    public void sing() {
        System.out.println("Tweet");
    }
}

public class Robin() {
    public void sing() {
        System.out.println("I'm a robin, tweet");
    }
}
```

If we were to make an instance of the `Robin` class, Java would default to the `sing` method in the `Robin` class.

```java
Robin r = new Robin();
r.sing();
// ^ This would print "I'm a robin, tweet"
```

### Abstract Methods

Let's say that we want all Shapes to compute their areas. We can use polymorphism to make the `area()` method something that all Shapes have.

We for this, we use the abstract keyword:

```java
public class Shape {
    // ...
    // Any class that inherits from Shape MUST have an area function
    public abstract double area();
    // ...
}
```

We can use parent classes to generalze various subclasses

Example:

```java
Shape[] array = new Shape[2];

array[0] = new Circle(5,5,15);
array[1] = new Rectangle(5, 10, 2, 3);

// The array can store all kind of Shapes without compiler errors
```

### Interfaces

Interfaces are like abstract class with ONLY abstract classes and constants

### Interfaces vs Abstract Classes