public class Cashier {
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServered;
    private int totalItemsServered;

    public Cashier() {
        queue = new ArrayQueue<Customer>();
        currentCustomer = null;
        totalCustomerWaitTime = 0;
        customersServered = 0;
        totalItemsServered = 0;
    }

    public void serveCustomers(int currentTime) {
        if (currentCustomer == null) {
            if (!queue.isEmpty()) {
                currentCustomer = queue.dequeue();
                totalCustomerWaitTime = currentTime - currentCustomer.getArrivalTime();
            }
        }

        if (currentCustomer.getNumberOfItems() <= 0) {
            currentCustomer = null;
            customersServered++;
        } else {
            currentCustomer.serve();
            totalItemsServered++;
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
        return customersServered;
    }

    public int getTotalItemsServered() {
        return totalItemsServered;
    }
}