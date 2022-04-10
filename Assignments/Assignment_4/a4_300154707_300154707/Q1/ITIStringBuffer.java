import java.util.Iterator;

public class ITIStringBuffer {

    SinglyLinkedList<Character> buffer;
    boolean changed = true;
    String rtnStr;
    public ITIStringBuffer() {
        buffer = new SinglyLinkedList<Character>();
    }

    public ITIStringBuffer(String  firstString){
        buffer = new SinglyLinkedList<Character>();
        for (Character c : firstString.toCharArray()) {
            buffer.add(c);
        }
        changed = true;
    }

    public void append(String nextString){
        for (Character c : nextString.toCharArray()) {
            buffer.add(c);
        }
        changed = true;
    }

    public String toString(){
        if (changed) {
            int counter = 0;
            char[] cArr = new char[buffer.size()];
            Iterator<Character> i = buffer.iterator();
            while (i.hasNext()) {
                cArr[counter] = i.next();
                counter++;
            }

            rtnStr = new String(cArr);
            changed = false;
        }
        
        return rtnStr;
    }

}
