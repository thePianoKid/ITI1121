public class Q3_SquareArray {
	public static int[] createArray(int size) {
		int[] rtnArr;
		rtnArr = new int[size]; 

		for (int i = 0; i < size; i++) {
			rtnArr[i] = i*i;
		}

		return rtnArr;
	}

	public static void main(String[] args) {
		int[] arr = createArray(12);

		for (int i = 0; i < arr.length; i++) {
			System.out.println("The square of "+i+" is: "+arr[i]);
		}
	} 
}
