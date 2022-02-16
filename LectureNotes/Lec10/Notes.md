# Lecture 10 Notes

## Stacks 📚
Software stacks are abstract data types similar to physical stacks

Think of...
- Stack of books
- Stack of plates

> *Formal Definition:* A **stack** is a linear data structure that is always accessed from the same extremity one element at a time, and that element is called the top of the stack

Stacks are widely used in apps and system programming:
- In compilers
- Artificial intelligence algorithms
- Undo operations in operating systems

The basic operations of a stack are:
- **push** add an element onto the top of the stack
- **pop** removes and returns the top element
- **empty** tests if the stack is empty

Let's pretend you are a librarian and you have a big stack of books. You can only read the book on the top and you can only take the book off the top.

The `push` method is like if you added a book onto the pile.

The `pop` method is like if you removed the book and read its contents.

And you can check if the pile is non-existant using the `empty` method.

To implement dynamic arrays in Java, you have to copy all the elements into a new array that has a bigger size. 