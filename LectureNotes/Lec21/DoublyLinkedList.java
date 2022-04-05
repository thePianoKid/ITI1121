public class DoublyLinkedList<E> implements List<E>{
    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;
        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

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
        head = new Node<E>(o, null, head);
    }
    /**
     * Adds o to the back of the list
     * @param o
     */
    public void add(E o) {
        if (o == null) {
            throw new NullPointerException("Can't add null reference to the list.");
        }

        Node<E> newNode = new Node<E>(o, null, null);
        
        if (head == null) { // special case
            head = newNode;
        } else { // general case
            Node<E> p = head;

            while (p.next != null) {
                p = p.next;
            }

            newNode.previous = p;
            p.next = newNode;
        }
    }

    public void add(int pos, E o) {
        if (o == null) {
            throw new NullPointerException("No null in maa haus!");
        }

        if (pos < pos || pos > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (pos == 0) { // special case: adding at position 0
            head = new Node<E>(o, null, head);
            if (tail == null) { // special case: list was empty
                tail = head;
            } else {
                head.next.previous = head;
            }
        } else {
            Node<E> p = head;

            for (int i = 0; i < pos-1; i++) {
                if (p == null) {
                    throw new IndexOutOfBoundsException(Integer.toString(pos));
                } else {
                    p = p.next;
                }
            }

            Node<E> q = p.next;
            p.next = new Node<E>(o, p, q);
            if (p == tail) {
                tail = p.next;
            } else {
                q.previous = p.next;
            }
        }
    }

    public void addLast(E t) {
        Node<E> newNode = new Node<E>(t, null, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        E savedValue = head.value;
        head = head.next;
        
        // if the head is null, the list is empty, so the tail should be wiped of its value
        if (head == null) {
            tail = null;
        }

        return savedValue;
    }

    public E removeLast() {
        E result;

        if (isEmpty()) {
            throw new IllegalStateException();
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

    public boolean remove(E o) {
        // If the list is empty, return false
        if (head == null) {
             return false;
        }

        Node<E> toDelete = null;
        // If the first element equals o, make the second element the new first element
        if (head.value.equals(o)) {
            toDelete = head;
            head = head.next;
        // General case
        } else {
            Node<E> p = head;

            // Look through the linked list and exit the loop only when the element is found, 
            // or when the end of the loop has been reached
            while (p.next != null && !p.next.value.equals(o)) {
                p = p.next;
            }
            
            // If the end of the loop was reached, return false
            if (p.next == null) {
                return false;
            }

            // If the element was found, replace it with the next element in the list
            toDelete = p.next;
            p.next = toDelete.next;
        }

        // scrubby scrubby...
        toDelete.value = null;
        toDelete.next = null;

        return true; 
    }

    public E remove(int pos) {
        // TODO: size() method is ineffcient; implement an instance variable
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        if (isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }

        Node<E> toRemove;
        if (pos == 0) {
            toRemove = head;
            head = head.next;
        } else {            
            Node<E> p = head;
    
            for (int i = 0; i < pos-1; i++) {
                if (p == null) {
                    throw new IndexOutOfBoundsException("Index is greater than the list.");
                }
                p = p.next;
            }

            toRemove = p.next;
            if (p.next != null) {
                p.next = p.next.next;
            }
        }

        E savedValue = toRemove.value;
        toRemove.value = null;
        toRemove.next = null;

        return savedValue;
    }

    public E get(int pos) {
        // TODO: size() method is ineffcient; implement an instance variable
        if (pos < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        if (isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }

        Node<E> p = head;

        for (int i = 0; i<pos-1; i++) {
            if (p == null) {
                throw new IndexOutOfBoundsException("Index is larger than the list.");
            }
            p = p.next;
        }

        return p.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean equals(DoublyLinkedList<E> otherList) {
        // This is the standard algo for checking for equality in list-like classes
        int size = this.size();
        if (otherList == null || size != otherList.size()) {
            return false;
        } 

        Node<E> thisCursor = this.head;
        Node<E> otherCursor = otherList.head;
        
        for (int i = 0; i < size; i++) {
            if (!thisCursor.value.equals(otherCursor.value)) {
                return false;
            }
            
            thisCursor = thisCursor.next;
            otherCursor = otherCursor.next;
        }
        
        return true;
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
