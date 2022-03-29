public class Test {
    public static void main(String[] args) {
        SinglyLinkedList<String> l = new SinglyLinkedList<String>();

        l.add("Gabe");
        l.add("Maria");

        System.out.println(l.toString());

        System.out.println(l.removeLast());

        System.out.println(l.toString());

        System.out.println(l.removeLast());

        System.out.println(l.toString());
    }
}