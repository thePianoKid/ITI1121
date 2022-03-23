public class Cashier {
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int totalCustomersServed;
    private int totalItemsServed;
    private int numberOfItems; // items remaining to be processed
    private int numberOfServedItems; // number of items that have been processed

    public Cashier() {
        queue = new ArrayQueue<Customer>();
        currentCustomer = null;
        totalCustomerWaitTime = 0;
        totalCustomersServed = 0;
        totalItemsServed = 0;
    }

    public void serveCustomers(int currentTime) {
        if (currentCustomer == null) {
            if (!queue.isEmpty()) {
                currentCustomer = queue.dequeue();
                totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
                numberOfItems = currentCustomer.getNumberOfItems();
            }
        } else {
            if (currentCustomer.getNumberOfItems() <= 0) {
                currentCustomer = null;
                totalCustomersServed++;
            } else {
                currentCustomer.serve();
                totalItemsServed++;
                numberOfItems--;
                numberOfServedItems++;
            }
        }
    }

    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalCustomersServed() {
        return totalCustomersServed;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return numberOfServedItems;
    }

    public String toString() {
        String firstLine = "The total number of customers served is " + totalCustomersServed + "\n";
        String secondLine = "The average number of items per customer was " + totalItemsServed/totalCustomersServed + "\n";
        String thirdLine = "The average waiting time (in seconds) was " + totalCustomerWaitTime/totalCustomersServed + "\n";

        return firstLine + secondLine + thirdLine;
    }
}