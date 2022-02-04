public class Circle extends Shape {
    private double radius;

    public Circle() {
        // On the first line of any constructor, you must call the parent class
        super();
        radius = 0;
    }

    public Circle(double x, double y, double radius) {
        // Calling super calls the parent class
        // Whenever this constructor runs, the Shape constructor also runs, 
        // even if it is not explicitly called
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    public String toString() {
        return super.toString() + " with radius " + this.radius;
    }

    public static void main(String args[]) {
        Circle c = new Circle(5, 5, 15);
        System.out.println(c);
    }
}
