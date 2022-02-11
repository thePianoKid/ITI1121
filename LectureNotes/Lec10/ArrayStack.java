public class ArrayStack implements Stack{
    private Object[] elems; // used to store the elements
    private int top; // designates the first free cell (first integer is zero)

    public ArrayStack (int capacity) {
        this.elems = new Object[capacity];
        this.top = 0;
    }

    // Required methods for the Stack interface
    public boolean isEmpty() {
        return top == 0;
    }

    public boolean isFull() {
        return elems.length <= top;
    }

    public void push (Object o) {
        // pre-condition: !isFull()
        elems[top] = 0;
        top++;
    }

    public Object pop() {
        // pre-condition: !isEmpty()
        Object saved;
        
        top--;
        saved = elems[top];
        // TODO: scrub memory
        elems[top] = null;
        
        return saved;
    }

    public Object peek() {
        // pre-condition: !isEmpty()
        return elems[top - 1];
    }
}
