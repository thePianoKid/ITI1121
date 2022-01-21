public class TestStrings {
    public static void main (String[] args) {
        String s1 = "My string";
        String s2 = "My string";

        if (s1 == s2) {
            // True
            System.out.println("s1 and s2 point to the same memory location");
        }

        // Java looks for strings that have the same value and assigns then to the same String object
        // String objects are immuntible

        s1 = "ab";
        s2 = s1 + "c";
        s1 = s1 + "c";

        // returns false
        boolean condition = s1 == s2; 

        // unless oyu are trying to find the equivilence of memory addresses,
        // it is good practice to use the builtin equals method
        if (s1.equals(s2)) {
            System.out.println("The content of s1 and s2 are the same");
        }
    }
}