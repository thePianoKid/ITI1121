public class RPN {
    public static int execute(String expression) {
        int l = 0;
        int r = 0;

        ArrayStack<Integer> operands = new ArrayStack<Integer>(100);

        Reader reader = new Reader(expression);

        while (reader.hasMoreTokens()) {
            Token token = reader.nextToken();
            if (token.isInteger()) {
                operands.push(token.iValue());
            } else {
                r = operands.pop();
                l = operands.pop();
                operands.push(eval(token, l, r));
            }
        }

        return operands.pop();
    }

    public static int eval(Token op, int l, int r) {
        System.out.println("L OP R: " + l + " " + 
        op.sValue() + " " + r);
        if (op.sValue().equals("+")){
            return l + r;
        } else if (op.sValue().equals("-")) {
            return l - r;
        } else if (op.sValue().equals("*")) {
            return l * r;
        } else if (op.sValue().equals("/")) {
            return l / r;
        } else {
            System.err.println("Not a valid symbol");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Expression: " + args[0]);

        int result = execute(args[0]);
        System.out.println(result);
    }
}