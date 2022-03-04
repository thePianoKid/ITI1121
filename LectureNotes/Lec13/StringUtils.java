import java.util.Arrays;

public class StringUtils {
    public static void main(String[] args) {
        String[][] twoDimArray = {null, {"c", "d"}, {"e", "t", "y", null}};
        String[] oneDimArray = new String[twoDimArray.length];
        String stringToAdd = "";

        for (int i = 0; i < twoDimArray.length; i++) {
            if (twoDimArray[i] != null) {
                for (int j = 0; j < twoDimArray[i].length; j++) {
                    if (twoDimArray[i][j] != null) {
                        stringToAdd += twoDimArray[i][j];
                    }
                }
                oneDimArray[i] = stringToAdd;
                stringToAdd = "";
            }
        }

        System.out.println(Arrays.toString(oneDimArray));
    }
}
