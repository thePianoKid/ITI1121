public class LinkedQueue<D> implements Queue<D> {
    private static class Elem<T> {
        private T value;
        private Elem<T> next;
        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<D> front;
    private Elem<D> rear;

    public LinkedQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(D newElement) {
        if (newElement == null) {
            throw new NullPointerException("Get that null outta ma haus");
        }
        Elem<D> newElem;
        newElem = new Elem<D>(newElement, null);

        // special case: empty queue
        if (isEmpty()) {
            front = rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem; // alternate: rear = rear.next;
        }
    }

    public D dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Dequeue called on empty queue");
        }
        D result = front.value;

        if (front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
        }
        
        return result;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer("[");
        
        if (!isEmpty()) {
            // This case is separated because we don't want a comma at the start 
            // of the front element
            Elem<D> cursor = front;
            buffer.append(cursor.value);

            while (cursor.next != null) {
                cursor = cursor.next;
                buffer.append("," + cursor.value);
            }
        }

        buffer.append("]");

        return buffer.toString();
    }
}
