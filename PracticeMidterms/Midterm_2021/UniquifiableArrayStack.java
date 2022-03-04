/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */

public class UniquifiableArrayStack<E> extends ArrayStack<E> {
	public Stack<E> uniquify() {
		Stack<E> reverseOutput = new ArrayStack<E>();
		Stack<E> reverseStack = new ArrayStack<E>();

		while (!this.isEmpty()) {
			E elem = this.pop();
			reverseStack.push(elem);

			if (reverseOutput.isEmpty()) {
				reverseOutput.push(elem);
			} else {
				if (!reverseOutput.peek().equals(elem)) {
					reverseOutput.push(elem);
				}
			}
		}

		while (!reverseStack.isEmpty()) {
			this.push(reverseStack.pop());
		}

		Stack<E> output = new ArrayStack<E>();

		while (!reverseOutput.isEmpty()) {
			output.push(reverseOutput.pop());
		}

		return output;
	}
}