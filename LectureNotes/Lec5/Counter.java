public class Counter {
    // The private keyword insures that Counter is a blackbox
    // Users can't meddle wtih the value variable,
    // they can only use the methods to increment it or reset it
    private int value = 0;

    public int getValue() {
        return this.value;
    }

    public void incr() {
        this.value++;
    }

    public void setVal(int value) {
        this.value = value;
    }

    public void reset() {
        value = 0;
    }
}
