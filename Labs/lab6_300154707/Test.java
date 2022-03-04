public class Test {
    public static void main(String[] args) {
        DynamicArrayStack<String> s = new DynamicArrayStack<String>(5);

        for (int i = 0; i < 3; i++) {
            s.push("Maria");
            s.push("Gabriel");
            s.push("Cole");
        }

        s.printStack();

        for (int i = 0; i < 1; i++) {
            s.pop();
        }

        s.printStack();

        s.clear();

        s.printStack();
    }
}