public class Test {
	public static void main(String[] args) {
		Token a, b, c;
		
		a = new Token("alpha");
		b = new Token("alpha");
		c = new Token(42);

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println();

		System.out.println("a.isString() is " + a.isString ());
		System.out.println("c.isString() is " + c.isString ());

		System.out.println();

		System.out.println("Token.equals(a,b) is " + Token.equals(a,b));
		System.out.println("Token.equals(b,c)) is " + Token.equals(b,c));
		System.out.println("Token.equals(c,null) is " + Token.equals(c,null));
	}
}