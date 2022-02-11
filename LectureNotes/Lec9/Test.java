public class Test {
    public static void main(String[] args) {
        // Testing Pair.java

        Account a, b;

        a = new Account(1, "Yo");
        b = new Account(1, null);

        Pair<Account> p = new Pair<Account>(a, b);

        Pair<String> p2 = new Pair<String>("Donald", "Trump");
        
        Pair<Integer> p3 = new Pair<Integer>(1, 2);

        System.out.println("p.getName(): " + p.getFirst().getName());
        System.out.println(p2.getSecond());
        System.out.println(p3.getSecond());
        
        // Test PairM2.java
        
        PairM2<Integer, String> p4 = new PairM2<Integer, String>(1, "asdf");
        
        Integer i = p4.getFirst();
        String j = p4.getSecond();
    }
}
