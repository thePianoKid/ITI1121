// A "Setter" is a method that changes the private variables in a class
// A "Getter" is a method that returns the value of a private variable

// Don't use if statements when programming the equals method

// Define constants instead of using random numbers in your program
// Ex:
// > static public final int HOURS_PER_DAY = 24;

// --------- Inheritance ---------
// Object Oriented languages offer tools to structure large systems
// Inheritance is one of them

// Inheritance allows to organize the classes hierarchically

// Abstract example:
// Jack Black is an actor
// Ben Aflec is an actor
// Jack Black and Ben Aflec both inherit from the actor class

// Another example:
// Bird is the superclass of Pigeon, i.e. Pigeon is a subclass of Bird
// You could have another class under Pigeon, say White Pigeon

// The phase "is a" is translated to Java using the extends keyword

// A class inherits all the characteristics (variables and methods) of its superclass(es)

// 1. A subclass inherits all the mothods and variables of its superclass(es)
// 2. A subclass can introduce/add new methods and variables
// 3. A subclass can override the methods of its superclass 

// --------- Shape Problem ---------
// Problem: A software system must be developed to represent various shapes
// All the shapes must havce two instance variables x and y to represent the center of the shape

// The Shape superclass has two instance variables x and y that the Circle and Rectangle sub classes inherit from

// All shapes should have the following methods:
// double getX();
// double getY();
// void moveTo(double x, double y);
// double area();
// String toString();

// area and toString should be delgated to other classes

// --------- Questions ---------
// Is it ok to use the this keyword when I am coding setters and getters?
// When we are programming the equals method, should we use the getter method?
