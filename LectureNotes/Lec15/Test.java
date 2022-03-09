public class Test {
    public static void a() {
        throw new RuntimeException("An Exception");
    }
    
    public static void main(String[] args) {
        System.out.println("-1-");

        try {
            a();
        } finally {
            System.out.println("finally!");
        }
    }
}