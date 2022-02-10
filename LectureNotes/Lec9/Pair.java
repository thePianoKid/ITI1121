// The Pair class is the perfect implementation of generic data structures
// T is a generic type; it will transform into what ever class was inputted
public class Pair<T> {
    // Stores pairs of two T objects
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }
}
