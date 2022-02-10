public class Test {
    public static void main(String[] args) {
        Account a, b;

        a = new Account(1, "Yo");
        b = new Account(1, null);

        Pair<Account> p = new Pair<Account>(a, b);
        
        System.out.println("p.getName(): " + p.getFirst().getName());
    }
}
