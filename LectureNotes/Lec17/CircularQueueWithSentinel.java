public class CircularQueueWithSentinel<E> implements Queue<E> {
    private E[] q;
    private int capacity = 1000;
    private int front, rear;

    @SuppressWarnings("unchecked")
    public CircularQueueWithSentinel() {
        q = (E[]) new Object[capacity];
        rear = -1;
        front = 0;
    }

    @SuppressWarnings("unchecked")
    public CircularQueueWithSentinel(int capacity) {
        q = (E[]) new Object[capacity];
        rear = -1;
        front = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return (rear != -1) && ((rear+1)%capacity == front);
    }

    public void enqueue(E o) {
        if (o == null) {
            throw new NullPointerException();
        }

        if (isFull()) {
            throw new IllegalStateException();
        }

        rear = (rear + 1)%capacity;
        q[rear] = o;

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

        if (front == rear) {
            rear = -1;
            front = 0;
        } else {
            front = (front+1)%capacity;
        }

        System.out.println("front: "+front);
        System.out.println("rear: "+rear);

        return val;
    }
}