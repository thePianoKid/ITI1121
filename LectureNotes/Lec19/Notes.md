# Lecture 19

> Note: singly and doubly linked lists will feature heavily on the final exam

## Definition of the List Abstract Data Type
The list is a linear abstract data type that places no restrictions on accessing the data; inspections, insertions and deletions can occur at any position.

`int size()` returns the number of elements
`E get(int index)` get the element at the specified index; counting starts at zero
`add(int index, E o)` adds an element at the inputted index
`remove(int index)` removes an element at the inputted index

## Implementations of List
- LinkedList
    - Singly linked list
    - Doubly linked list
    - Dummy node
    - Iterative list processing
    - Recursive list processing

The simplest of the linked list implementations is the singly linked list. A common implemenations uses a static nested lasss, called Node here.

```java
private static class Node<E> {
    private E value;
    private Node<E> next;
    private Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}
```

## Outline of the `List.remove(E o)` Method
- Accessing elements by content
- Returns `true` if `o` was successfully removed and false otherwise
- Outline of the implementation:

1. Traversing the list;
2. Stopping criteria
3. Removal
