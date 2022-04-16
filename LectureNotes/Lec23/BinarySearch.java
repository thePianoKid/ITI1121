public class BinarySearch {
    private static int binSearch (int value, int[] array, int lo, int hi) {
        // base case: value was not found
        if (lo > hi) {
            return -1;
        }
        
        // Base case: value was found in the middle
        int middle = (lo+hi)/2;
        if (value == array[middle]) {
            return middle;
        }

        // General case
        int newLo, newHi;
        if (value < array[middle]) {
            newLo = lo;
            newHi = middle - 1;
        } else {
            newLo = middle + 1;
            newHi = hi;
        }

        return binSearch(value, array, newLo, newHi);
    }

    public static int binarySearch(int value, int[] array) {
        return binSearch(value, array, 0, array.length-1);
    }
}
