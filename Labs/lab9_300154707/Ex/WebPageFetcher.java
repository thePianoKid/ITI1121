import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class WebPageFetcher {
    public static void printPage(URL address) throws IOException {
        InputStreamReader is = new InputStreamReader(address.openStream());
        BufferedReader input = new BufferedReader(is);
        
        int lineNumber = 0;
        String line;
        
        line = input.readLine();
        while(line != null) {
            System.out.println(lineNumber + ": " + line);
            line = input.readLine();
            lineNumber++;
        }

        input.close();
    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL address = new URL(args[0]);
        printPage(address);
    }
}