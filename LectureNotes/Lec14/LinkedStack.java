public class LinkedStack<T> implements Stack<T> {
    // The Elem class is used to organize the linked
    // elements of our linked list
    private static class Elem<K> {
        private K value;
        private Elem<K> next;
    
        private Elem(K value, Elem<K> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<T> top = null;

    public boolean isEmpty() {
        return top == null;
    }

    public T push(T elem) {
        top = new Elem<T>(elem, top);
        
        return elem;
    }

    public T pop() {
        // Recall that the user is expected to 
        // use the isEmpty method, to make sure
        // pop doesn't return an error
        T result = top.value;
        top = top.next;

        return result;
    }
    
    public T peek() {
        return top.value;
    }

    public String toString() {
        String result = "[";
        Elem<T> pointer = top;
        
        while (pointer != null) {
            result += pointer.value;

            if (pointer.next != null) {
                result += ", ";
            }

            pointer = pointer.next;
        }

        return result + "]";
    }
}
