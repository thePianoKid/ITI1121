import java.util.Random;

public class Customer {
    private int arrivalTime;
    private int initialNumberOfItems;
    private int numberOfItems;
    // TODO: 
    // Make sure this is the correct value
    private static final int MAX_NUM_ITEMS = 20;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;

        Random generator = new Random();
        this.initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;

        this.numberOfItems = initialNumberOfItems;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void serve() {
        if (numberOfItems <= 0) {
            throw new IndexOutOfBoundsException("Number of items cannot be negative.");
        }
        numberOfItems--;
    }
}