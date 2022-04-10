import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private static class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public LinkedList() {
        head = new Node<E>(null, null, null); // dummy node!
        head.prev = head.next = head;
        size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {

        private Node<E> current;
        private int index;

        public LinkedListIterator() {
            current = head;
            index = 0;
        }

        public LinkedListIterator(int nextIndex) {
            if (nextIndex >= size) {
                throw new IndexOutOfBoundsException();
            }

            current = head;
            for (int i = 0; i < nextIndex; i++) {
                current = current.next;
            }
            index = nextIndex;
        }

        public LinkedListIterator(Iterator<E> other) {
            int counter = 0;
            while (other.hasNext()) {
                counter++;
                other.next();
            }

            index = size - counter;
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }   
        }

        public boolean hasNext() {
            return (current.next != head);
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            current = current.next;

            return current.value;
        }

        public int nextIndex() {
            index++;
            return index-1;
        }
    }

    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public Iterator<E> iterator(int nextIndex) {
        return new LinkedListIterator(nextIndex);
    }

    public Iterator<E> iterator(Iterator<E> other) {
        return new LinkedListIterator(other);
    }

    public int size() {
        return size;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> p = head.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.value;
    }

    public void addFirst(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> second = head.next;

        head.next = new Node<E>(elem, head, second);
        second.prev = head.next;

        size++;
    }

    public void add(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> before = head.prev, after = head;

        before.next = new Node<E>(elem, before, after);
        after.prev = before.next;

        size++;
    }
    
}
