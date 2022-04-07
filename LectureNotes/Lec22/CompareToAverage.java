public class CompareToAverage {
    public static void main(String[] args) {
        int sum = 0;
        int n = 0;

        LinkedList<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            l.addLast(i);
        }

        Iterator<Integer> i = l.iterator();
        while (i.hasNext()) {
            Integer val = i.next();
            sum += val;
            n++;
        }

        i = l.iterator();
        while(i.hasNext()) {
            Integer val = i.next();
            System.out.println("Average: " + sum/n);
            System.out.println("Current value: " + val);
        }
    }
}