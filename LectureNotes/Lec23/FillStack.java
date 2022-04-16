import java.util.Stack;

public class FillStack {
    private static void recurse (int i) {
        try {
            System.out.println("Depth: " + i);

            recurse(i + 1);
        } catch (StackOverflowError error) {
            System.out.println("Stack overflow!");
        }
    }

    public static void main(String[] args) {
        recurse(0);
    }
}