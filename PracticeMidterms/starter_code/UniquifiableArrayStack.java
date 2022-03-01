/**
 * COPYRIGHTED MATERIAL -- DO NOT DISTRIBUTE
 *
 * @author Guy-Vincent Jourdan
 * @author Mehrdad Sabetzadeh 
 */

public class UniquifiableArrayStack<E> extends ArrayStack<E> {
	public Stack<E> uniquify() {
		Stack<E> uniqueStackRev = new ArrayStack<E>();
		Stack<E> copyStack= new ArrayStack<E>();

		E compEle = this.pop();
		copyStack.push(compEle);
		uniqueStackRev.push(compEle);

		while (!this.isEmpty()) {
			E current = this.pop();
			copyStack.push(current);
			if (!compEle.equals(current)) {
				compEle = current;
				uniqueStackRev.push(compEle);
			}
		}

		Stack<E> uniqueStack = new ArrayStack<E>();

		while (!uniqueStackRev.isEmpty()) {
			uniqueStack.push(uniqueStackRev.pop());
		}

		while (!copyStack.isEmpty()) {
			this.push(copyStack.pop());
		}

		return uniqueStack;
	}
}