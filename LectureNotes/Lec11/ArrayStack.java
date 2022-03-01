public class ArrayStack <E> implements Stack <E>{
    private E[] elems; // used to store the elements
    private int top; // designates the first free cell (first integer is zero)

    @SuppressWarnings("unchecked")
    public ArrayStack (int capacity) {
        this.elems = (E[]) new Object[capacity];
        this.top = 0;
    }

    // Required methods for the Stack interface
    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return elems.length <= top;
    }

    public void push (E o) {
        // pre-condition: !isFull()
        elems[top] = o;
        top++;
    }

    public E pop() {
        // pre-condition: !isEmpty()
        E saved;
        
        top--;
        saved = elems[top];
        // the top value is removed and marked for garbage collection
        // called "scrubbing"
        elems[top] = null; 
        
        return saved;
    }

    public E peek() {
        // pre-condition: !isEmpty()
        return elems[top - 1];
    }
}
