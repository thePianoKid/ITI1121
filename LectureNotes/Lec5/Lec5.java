// Classes:
// Inside a class you can find
	// variables and methods (nested classes come later)
	// each belongs to the class or the instance
	// each "thing" inside a class can be public, package, protected or private
	// each can be final or not

// In other words:
// Static variables and methods can be accessed by any instance of the class:
// Ex:
// import Ticket
// > Ticket ticket1 = new Ticket(08324);
// > ticket1.getSerialNumber();
// If getSerialNumber is a static class, it will be the same for every instance of Ticket
// If getSerialNumber is not a static class, it will be different for every instance of Ticket

// The final keyword means that it can be initialzed only once

// Constructors:
// A constructor is a block of statements that are executed when an object created
// A constructor has the same name as its class
// Can only be called once, when the object is created in the context "new ..."
// A constructor has no return type

// Interface:
// An interface is whatever is public to other classes 
// The interface is made up of the public variables and methods