public class TestCounter {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println("counter: " + counter.getValue());
        counter.incr();
        System.out.println("counter: " + counter.getValue());
        counter.setVal(10);
        System.out.println(counter.getValue());
    }
}
