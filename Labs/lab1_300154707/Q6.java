import java.util.Scanner;

public class Q6{
	public static void main(String[] args){
        double[] grades;
        grades = new double[10];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < grades.length; i++) {
            System.out.print("Enter Student "+i+" grade: ");
            grades[i] = sc.nextInt();
        }

        sc.close();
	}

    // helper method that uses the selection-sort algorthim to sort the grades
    public static void sort(double[] notes) {
        int i, j, argMin;
        double tmp;

		for (i = 0; i < notes.length - 1; i++) {
			argMin = i;
			for (j = i + 1; j < notes.length; j++) {
				if (notes[j] > notes[argMin]) {
					argMin = j;
				}
			}

			tmp = notes[argMin];
			notes[argMin] = notes[i];
			notes[i] = tmp;
		}
    }

    // calculates the class average
	public static double calculateAverage(double[] notes){
		double sum = 0;

        for (double grd : notes) {
            sum += grd;
        }

        return sum/notes.length;
	}

    // calcuates the class median (https://en.wikipedia.org/wiki/Median)
	public static double calculateMedian(double[] notes){
		int len = notes.length;
        double median = 0;

        sort(notes);

        if (len % 2 == 1) {
            int i = (len-1)/2;
            median = notes[i];
        } else {
            int j = len/2;
            int k = j - 1;
            median = (notes[j] + notes[k])/2;
        }

        return median;
	}

    // finds the number of students that failed 
	public static int calculateNumberFailed(double[] notes){
        int counter = 0;

		for (double grd : notes) {
            if (grd < 50) {
                counter++;
            }    
        }

        return counter;
	}

    /* uses the CalculateNumberFailed method to find the number of 
    students that passed */
	public static int calculateNumberPassed(double[] notes){
        return notes.length - calculateNumberFailed(notes);
    }

}