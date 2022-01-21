public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
        int i, j, argMax;
        char tmp;

		for (i = 0; i < values.length - 1; i++) {
			argMax = i;
			for (j = i + 1; j < values.length; j++) {
				if (values[j] > values[argMax]) {
					argMax = j;
				}
			}

			tmp = values[argMax];
			values[argMax] = values[i];
			values[i] = tmp;
		}
	}

}