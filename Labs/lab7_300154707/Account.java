public class Account {
    private int balence;

    public Account() {
        balence = 0;
    }

    public void deposit(int amount) {
        balence += amount;
        System.out.println("new balence="+balence+"$");
    }

    public void witdraw(int amount) throws NotEnoughMoneyException {
        if (balence - amount < 0) {
            throw new NotEnoughMoneyException(amount, balence);
        }

        balence -= amount;
        System.out.println("new balence="+balence+"$");
    }
}