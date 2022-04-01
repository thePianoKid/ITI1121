public interface List<E> {
    void add(int index, E Elem);
    void add(E elem);
    boolean remove(E elem);
    E get(int index);
    int size();
    boolean isEmpty();
}