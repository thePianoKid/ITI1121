public class Test {
    public static void main(String[] args) {
        A testVar = new A(10, 8, 7);

        DeepCopyable deepCopy = testVar.deepCopy();

        A newVar = (A) deepCopy;
    }
}