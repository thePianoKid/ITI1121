import java.util.NoSuchElementException;

public class OrderedList<E extends Comparable<E>> {
    private static class Node<E> {
        private E value;
        private Node<E> next;
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> first;
    public OrderedList() {
        first = null;
    }

    public int size() {
        return size(first);
    }

    private int size(Node<E> p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    }

    public void remove(E o) {
        if (first == null) {
            throw new NoSuchElementException();
        }

        if (first.value.equals(o)) { // special case: removal of first element
            first = first.next;
        } else {
            remove(first, o);
        }
    }

    private void remove(Node<E> p, E o ) {
        if (p.next == null) {
            throw new NoSuchElementException();
        }

        if (p.next.value.equals(o)) {
            p.next = p.next.next;
        } else {
            remove(p.next, o);
        }
    }
}