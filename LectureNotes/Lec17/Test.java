public class Test {
    public static void main(String[] args) {
        Queue<String> q = new CircularQueueWithSentinel<String>();

        for (int i = 0; i < 5; i++) {
            q.enqueue("" + i);
        }

        q.dequeue();
        q.dequeue();
    }
}