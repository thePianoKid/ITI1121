public class SinglyLinkedList<E> implements List<E>{
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;

    public int size() {
        int size = 0;
        Node<E> p = head;
        
        while (p != null) {
            p = p.next;
            size++;
        }

        return size;
    }

    /**
     * Adds o to the front of the list
     * @param o
     */
    public void addFirst(E o) {
        if (o == null) {
            throw new NullPointerException("Can't add null reference to the list.");
        }
        head = new Node<E>(o, head);
    }
    /**
     * Adds o to the back of the list
     * @param o
     */
    public void add(E o) {
        if (o == null) {
            throw new NullPointerException("Can't add nul reference to the list.");
        }

        Node<E> newNode = new Node<E>(o, null);
        
        if (head == null) { // special case
            head = newNode;
        } else { // general case
            Node<E> p = head;

            while (p.next != null) {
                p = p.next;
            }

            p.next = newNode;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        E savedValue = head.value;
        head = head.next;
        return savedValue;
    }

    public E removeLast() {
        E result;

        if (isEmpty()) {
            throw new NullPointerException();
        } else if (head.next == null) { // special case
            result = head.value;
            head = null;
        } else { // general case
            Node<E> p = head;

            while(p.next.next != null) {
                p = p.next;
            }

            result = p.next.value;
            p.next = null;
        }

        return result;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer("[");
        
        if (!isEmpty()) {
            // This case is separated because we don't want a comma at the start 
            // of the front element
            Node<E> cursor = head;
            buffer.append(cursor.value);

            while (cursor.next != null) {
                cursor = cursor.next;
                buffer.append("," + cursor.value);
            }
        }

        buffer.append("]");

        return buffer.toString();
    }
}
