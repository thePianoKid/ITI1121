public abstract class AbstractClassEx {
    private double val;
    
    public AbstractClassEx() {
        val = 0;
    }

    public AbstractClassEx(double val) {
        this.val = val;
    }
    
    public final double getVal() {
        return this.val;
    }

    public abstract double area();
}