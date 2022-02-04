import javax.swing.border.SoftBevelBorder;

public class Test {
    public static void main(String args[]) {
        Shape s1 = new Circle(5, 5, 15);
        Shape s2 = new Circle(7, 7, 90);

        Shape[] array = {s1, s2};

        Sorter.sort2(array);

        // for (Shape s : array) {
        //     System.out.println(s);
        // }

        Displayable[] arr2 = new Displayable[2];
        // We can do this because Displayable is more abstract than shape
        arr2[0] = array[0];
        arr2[1] = array[1];

        for (Displayable dis : arr2) {
            dis.
            display();
        }
    }
}
