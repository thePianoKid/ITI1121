/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */


public class A implements DeepCopyable { // complete the class declaration as required
	
	private int a , b, c;

	public A(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// ADD YOUR CODE HERE

	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()) {
			return false;
		}

		A o = (A) other;

		if (a != o.a || b != o.b || c != o.c) {
			return false;
		}

		return true;
	}

	public DeepCopyable deepCopy() {
		DeepCopyable deepCopy = new A(a, b, c);

		return deepCopy;
	}

}
