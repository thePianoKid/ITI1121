public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<Integer>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue);
            System.out.println(queue.dequeue());
        }
    }
}