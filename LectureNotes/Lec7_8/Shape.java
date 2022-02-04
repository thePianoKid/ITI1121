// double getX(); returns the value of x
// double getY(); returns the value of Y
// void moveTo(); moves the shape to a new location
// double area(); calculates the area of the shape
// String toString(); returns the string representation of the shape

// The Shape class should exend to specific shapes

// You CANNOT extend two classes at once
public abstract class Shape implements Comparable, Displayable {
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

    // Since the area class is required of all sub classes, the 
    // area class can be used like a normal class in Shape
    public abstract double area();

    public int compareTo(Comparable o) {
        // This ensures that only Shapes are being compared
        // If another subclass of Comparable was being compared, an error would be thrown
        Shape other = (Shape) o;

        int result;

        if (this.area() < other.area()) {
            result = -1;
        } else if (this.area() == other.area()) {
            result = 0;
        } else {
            result = 1;
        }

        return result;
    }

    public void display() {
        // if the variable is of type "Circle", then calling this method would be the same as calling
        // System.out.println(Circle(parameters here...))
        System.out.println(this);
    }

    public String toString() {
        return "Located at: ("+this.x+", "+this.y+")";
    }
}
