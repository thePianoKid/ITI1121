# Lecure 22

## Implementation A - Traversing a linked list inside the class
```java
Node<E> p = head;
while (p != null) {
    System.out.println(p.value);
    p = p.next;
}
```

## Implementation B - Traversing a linked list outside the class
```java
for (int i=0; i < colors.size(); i++) {
    System.out.println(color.get(i));
}
```

For 80 000 nodes it takes 6.5 minutes traversing the list using `get(pos)` vs 12ms using the other approach

If you look at the implementations, A is linear and B is exponential

## Implementation of Iterator Class
### First Implementation
In our first implementation, the class LinkedList developed earlier is modified to implement the interface Iterator. 

- Functional definition of the `next()` method
    - Iterator moves one position forward
    - Then returns the value of the current element

This implementation does not allow for multiple iterators

### Second Implementation
Let's create the following top-level class (in the same package as LinkedList), this will require that i) Node is also a top-level class and ii) the variable head should be protected

### Third Implementation 
`LinkedListIterator` is now a static nested class of `LinkedList`; which allows us to change the visibility of the variable `head` back to `private`. 

### Using an inner class
An instance of an inner class cannot exist on tis own, it requires an instance of the outer class (the converse is not true)

An instance of an inner class has access to the instance variables (and mehtods) of the outer object that created it

```java
public class Outer {
    class Inner {
        Inner() {
            System.out.println("new instance of inner class");
        }
    }

    public Outer() {
        System.out.println("new instance of outer class");
    }

    class Test {
        public static void main(String args) {
            Outer o = new Outer();
        }
    }
}
```

This code snippet prints `new instance of outer class` only

An instance of an inner calss has access to the variables and method sof its outer class (huzzah)

**To summarize:**
- An inner classs is a nested class that is not explicitely or implicitely declared static

- An object of the outer class creates an instacne of an inner class
    - An object is an inner class has acces to the instacne variables and methods of its outer object

### Fourth Implementation 
