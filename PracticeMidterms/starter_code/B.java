/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */

public class B implements DeepCopyable { // complete the class declaration as required

	private A a1, a2;

	public B( A a1, A a2){
		this.a1 = a1;
		this.a2 = a2;
	}

	public A getA1() {
		return a1;
	}

	public A getA2() {
		return a2;
	}

	// ADD YOUR CODE HERE
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()) {
			return false;
		}

		B o = (B) other;

		if (o.a1 == null) {
			if (a1 != null) {
				return false;
			}
		} else if (!a1.equals(o.a1)) {
			return false;
		} 

		if (o.a2 == null) {
			if (a2 != null) {
				return false;
			}
		} else if (!a2.equals(o.a2)) {
			return false;
		}

		return true;
	}

	public DeepCopyable deepCopy() {
		DeepCopyable copiedA1 = a1.deepCopy();
		DeepCopyable copiedA2 = a2.deepCopy();

		A typeCastA1 = (A) copiedA1;
		A typeCastA2 = (A) copiedA2;

		DeepCopyable deepCopy = new B(typeCastA1, typeCastA2);

		return deepCopy;
	}
}