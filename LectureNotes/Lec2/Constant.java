public class Constant {
    private String name;
    private double value;
    public Constant ( String name, double value) {
        this.name = name;
        this.value = value;
    }

    public static void main (String[] args) {
        Constant c; // If c is not assigned (if c does not "equal" anything, an error is returned)
        c = new Constant("golden ratio", 1.618);
    }
}
