public class NotEnoughMoneyException extends IllegalStateException {
    private int amount;
    private int balence;
    private int missingAmount;
    private String message;

    public NotEnoughMoneyException(int amount, int balence) {
        super();
        this.amount = amount;
        this.balence = balence;
        this.missingAmount = Math.abs(amount - balence);
        this.message = "You do not have enough money to withdraw " + amount + "$";
    }

    public int getAmount() {
        return amount;
    }

    public int getBalence() {
        return balence;
    }

    public int getMissingAmount() {
        return missingAmount;
    }

    @Override
    public String getMessage() {
        return message;
    }
}