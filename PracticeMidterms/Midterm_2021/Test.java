public class Test {
    public static void main(String[] args) {
        UniquifiableArrayStack<String> stringStack = new UniquifiableArrayStack<String>();

        stringStack.push("Cole");

        ArrayStack<String> dulplicateStack = stringStack;

        stringStack.uniquify();
    }
}