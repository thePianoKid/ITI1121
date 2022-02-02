// double getX(); returns the value of x
// double getY(); returns the value of Y
// void moveTo(); moves the shape to a new location
// double area(); calculates the area of the shape
// String toString(); returns the string representation of the shape

// The Shape class should exend to specific shapes
public abstract class Shape {
    private double x;
    private double y;

    // Constructor:
    public Shape() {
        x = 0;
        y = 0;
    }

    // Constructor that takes parameters: (example of polymophism)
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    public final void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Located at: ("+this.x+", "+this.y+")";
    }

    public abstract double area();
}
