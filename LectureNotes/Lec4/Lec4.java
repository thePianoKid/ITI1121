// Object-Oriented Programming and Software Design
// The design of software systems in the terms of classes and objects makes designing software systems more concrete

// Abstraction
// An abstraction allows us to ignore the details of a concept and to focus on its important characteristics
// The term "black-box" is often used as a an analogy for an abstraction

// Example:
// Reducing a car to a size and plate number
// A car is much more complecated, but we only care about the size and plate number

// If the method is well designe, and depends only on its formal parameters, then
// it can be seen as a black box

// Data abstraction 
// Example:
// Records and structures were amongst the first form of data abstraction
// Thye allow us to model the data and to handle the data as a unit

// Prodedural Abstraction + Data Abstraction = Object-Oriented Programming
// The central concept of object-oriented programming is the object
// An object consists of
    // data abstractions (variables)
    // proceduaral abstractions (methods)
// A software system consists of a collection of objects interacting together to 
// solve a common task

// Activities of SOftware Development
// 1. Requirements analysis (defining the problem)
// 2. Design 
    // how to break the system into subsystems and what are the interactions between subsystems
// 3. Programming 
// 4. Quality assurance
// 5. Project management

// Two classes are coupled if they are dependant on eachother 
// Class coupling is discouraged in Java

// Classes vs Objects
// Objects only exist during run time
// Objects are "examples" of classes

// Example:
// In the case of a chess game application there can be a class which describes the 
// properties and behaviors that are common to all the Pieces

// During the execution of the program, there will be many "instances" created
// black king, white queen, etc 

// > ChessPiece whiteQueen = new ChessPiece("queen", "white", "B3"); 
// ^ instantiating the ChessPiece class
// whiteQueen is a reference variable to a ChessPiece object

// classses ALWAYS start with a capital letter 

// Example: MyInteger

// Instance Variables
// The class lists all the variables that each object must have in order to model 
// the given concept
// When a variable is declared to be an instance variable, it means that all the
// instances of the class will reserve space for the variable

// Example:
// > public class Point {
    // int x = 0;
// }

// Continued next lecture...