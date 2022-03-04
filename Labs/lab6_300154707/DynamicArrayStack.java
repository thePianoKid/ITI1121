import java.util.Arrays;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 10;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        elems = (E[]) new Object[capacity];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        if (DEFAULT_INC <= (elems.length - top)) {
            E[] tmp = (E[]) new Object[elems.length-DEFAULT_INC];
            
            top = 0;
            for (int i = 0; i < tmp.length; i++) {
                if (elems[i] != null) {
                    top++;
                }
                tmp[i] = elems[i];
            }

            elems = tmp;
        }

        E saved = elems[ --top ];

        elems[ top ] = null;

        return saved;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        // TODO: FIX ME!!
        if (top == elems.length) {
            E[] tmp = (E[]) new Object[elems.length+DEFAULT_INC];
            
            for (int i = 0; i < elems.length; i++) {
                tmp[i] = elems[i];
            }

            elems = tmp;
        }

        elems[ top++ ] = element;
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }

    public void printStack() {
        System.out.println(Arrays.toString(elems));
    }

}