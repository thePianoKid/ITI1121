public class MyInteger {
    // int value; // Bad practice

    // public static void main (String[] args) {
    //     MyInteger a;

    //     a = new MyInteger(); // No need to write a constructor if the class takes no parameters
    //     a.value = 33;
    //     a.value++;

    //     System.out.println(a.value);
    // }

    int value; // Bad pratice

    MyInteger (int v) { 
        this.value = v;
    }

    public static void main (String[] args) {
        MyInteger i;
        i = new MyInteger(10);
        
        MyInteger alias = i; // the alias variable points to the same place that i points to

        alias.value++;

        System.out.println(i.value);
    }
}
