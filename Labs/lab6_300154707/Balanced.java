/**
 *
 * @author Marcel Turcotte, Universit� d'Ottawa/University of Ottawa
 */

public class Balanced {

    public static boolean algo1( String s ) {

        int curly = 0;
        int square = 0;
        int round = 0;

        for ( int i=0; i<s.length(); i++ ) {

            char c = s.charAt( i );

            switch ( c ) {
            case '{':
                curly++;
                break;
            case '}':
                curly--;
                break;
            case '[':
                square++;
                break;
            case ']':
                square--;
                break;
            case '(':
                round++;
                break;
            case ')':
                round--;
            }
        }
        return curly == 0 && square == 0 && round == 0;
    }

    public static boolean algo2(String expression) {
        char[] charExpression = expression.toCharArray();
        ArrayStack<String> bracketStack = new ArrayStack<String>(5);

        for (char c : charExpression) {
            bracketStack.printStack();
            if (c == '(' || c == '[' || c == '{') {
                bracketStack.push(c+"");
            } else if (c == ')' || c == ']' || c == '}') {
                if (bracketStack.isEmpty()) {
                    return false;
                } else {
                    if (c == ']' && !bracketStack.pop().equals("[")) { return false; }
                    if (c == ')' && !bracketStack.pop().equals("(")) { return false; }
                    if (c == '}' && !bracketStack.pop().equals("{")) { return false; }
                }
            }
        }

        if (!bracketStack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main( String[] args ) {
        for ( int i=0; i<args.length; i++ ) {
            System.out.println( "algo1( \"" + args[ i ] + "\" ) -> " + algo2( args[ i ] ) );
        }
    }
}