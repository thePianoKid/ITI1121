/**
 * This class contains methods that are generally useful for programming in Java
 * 
 * @author Gabriel Braden
 */

public class Utils {

    /**
     * Returns a copy of the array 'in' where each word occurring in the array
     * 'what' has been replaced by the word occurring in the same position
     * in the array 'with'.
     *
     * @param in an array of Strings;
     * @param what an array of words to be replaced;
     * @param with an array of replacement words;
     * @return a new array idententical to 'in' except that all the occurrences of words
     * found in 'what' have been replaced by the corresponding word from 'with'.
     */

    public static String[] findAndReplace( String[] in, String[] what, String[] with ) {

        String[] out = null; // The new array to be returned
	    boolean valid = true; // True if the pre-conditions are satistified

      	// Testing pre-conditions

      	if ( in == null || what == null || with == null ) {
      	    valid = false;
      	} else if (what.length != with.length) {
              // more or less 16 lines missing
              valid = false;
        } else if (containsNull(in) || containsNull(what) || containsNull(with)) {
            valid = false;
        }

      	if ( valid ) {
            out = new String[ in.length ];
            for (int i = 0; i < in.length; i++) {
                int replacementElementIndex = findElement(what, in[i]); 
                if (replacementElementIndex != -1) {
                    out[i] = with[replacementElementIndex];
                } else {
                    out[i] = in[i];
                }
            }
      	}
        // Returning a reference to the newly created array that
        // contains the same entries as 'in' except that all the
        // occurrences of words from 'what' have been replaced by
        // their corresponding occurrence from 'with'.

        return out;
    }

    // ---------------------- Helper Methods ----------------------
    /**
     * Determines whether an array of strings contains at least one null value
     * 
     * @param arr
     * @return true if null is found in the array
     */
    private static boolean containsNull(String[] arr) {
        for (String s : arr) {
            if (s == null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Finds a strings in an array of strings
     * 
     * @param searchArr
     * @param key
     * @return the index of the found elements; if the object is not found, this method
     * returns the integer -1
     */
    private static int findElement(String[] searchArr, String key) {
        for (int i = 0; i < searchArr.length; i++) {
            if (key.equals(searchArr[i])) {
                return i;
            }
        }

        return -1;
    }
}
