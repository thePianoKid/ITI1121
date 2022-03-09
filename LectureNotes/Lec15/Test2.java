public class Test2 {
    public static void main(String[] args) throws Exception {
        System.out.println("1");

        if (true) {
            throw new Exception("Yo Dog");
        }

        System.out.println("2");

    }
}
