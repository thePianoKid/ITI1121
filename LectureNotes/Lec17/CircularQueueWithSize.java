public class CircularQueueWithSize<E> implements Queue<E> {
    private E[] q;
    private int capacity = 1000;
    private int front, rear, size;

    @SuppressWarnings("unchecked")
    public CircularQueueWithSize() {
        q = (E[]) new Object[capacity];
        size = front = rear = 0;
    }

    @SuppressWarnings("unchecked")
    public CircularQueueWithSize(int capacity) {
        q = (E[]) new Object[capacity];
        rear = -1;
        front = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(E o) {
        if (o == null) {
            throw new NullPointerException();
        }

        if (!isEmpty()) {
            rear = (rear+1)%capacity;
        }

        q[rear] = o;
        size++;
        System.out.println("front: "+front);
        System.out.println("rear: "+rear);
    }

    public E peek() {
        if(isEmpty()) {
            throw new IllegalStateException();
        } 

        return q[front];
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        
        E val = q[front];
        q[front] = null;
        size--;

        if (size == 0) {
            front = rear = 0;
        } else {
            front = (front+1)%capacity;
        }

        System.out.println("front: "+front);
        System.out.println("rear: "+rear);

        return val;
    }
}