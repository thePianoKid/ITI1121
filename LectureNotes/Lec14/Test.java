public class Test {
    public static void main(String[] args) {
        Stack<String> myStack = new LinkedStack<String>();

        for(int i = 0; i < args.length; i++) {
            myStack.push(args[i]);
        }
        
        System.out.print(myStack.toString());

        System.out.println();
    }
}