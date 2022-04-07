import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> l = new LinkedList<String>();
        l.addLast("Gabe");
        l.addLast("Maria");
        l.addLast("Cole");
        Iterator<String> i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}