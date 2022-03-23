import java.util.Random;

public class Customer {
    private int arrivalTime;
    private int numberOfItems;
    private int numberOfServedItems;
    // TODO: 
    // Make sure this is the correct value
    private static final int MAX_NUM_ITEMS = 20;

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;

        Random generator = new Random();
        this.numberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
        this.numberOfServedItems = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return numberOfServedItems;
    }

    public void serve() {
        if (numberOfItems <= 0) {
            throw new IndexOutOfBoundsException("Number of items cannot be negative.");
        }
        numberOfItems--;
        numberOfServedItems++;
    }
}