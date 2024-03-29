public class RPN2 {
    public static String eval(Token op, String l, String r) {
        return "(" + l + op.sValue() + r + ")";
    }

    public static String execute(String expression) {
        String l = null;
        String r = null;

        ArrayStack<String> operands = new ArrayStack<String>(100);

        Reader reader = new Reader(expression);

        while (reader.hasMoreTokens()) {
            Token token = reader.nextToken();
            if (token.isInteger()) {
                operands.push(Integer.valueOf(token.iValue()).toString());
            } else {
                r = operands.pop();
                l = operands.pop();
                operands.push(eval(token, l, r));
            }
        }

        return operands.pop();
    }

    public static void main(String[] args) {
        System.out.println("RPN expression: " + args[0]);

        String result = execute(args[0]);
        System.out.println("Infix expression: " + result);
    }
}
