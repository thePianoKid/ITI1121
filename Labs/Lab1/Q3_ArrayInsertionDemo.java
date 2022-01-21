public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
		int[] rtnArr;
        rtnArr = new int[beforeArray.length + 1];

        for (int i = 0; i < rtnArr.length; i++) {
            if (i == indexToInsert) {
                rtnArr[i] = valueToInsert;
            } else {
                if (i > indexToInsert) {
                    rtnArr[i] = beforeArray[i-1];
                } else {
                    rtnArr[i] = beforeArray[i];
                }
            }
        }

        return rtnArr;
	}

	public static void main(String[] args){
		int[] testArr = {1, 5, 4, 7, 9, 6};

        System.out.println("Array before insertion: ");
        for (int i = 0; i < testArr.length; i++) {
            System.out.println(testArr[i]);
        }

        int [] newArr = insertIntoArray(testArr, 3, 15);

        System.out.println("Array after insertion of 15 at position 3:");
        for (int j = 0; j < newArr.length; j++) {
            System.out.println(newArr[j]);
        }
	}
}
