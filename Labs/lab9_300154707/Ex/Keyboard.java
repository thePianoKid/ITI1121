// Reads keyboad input, displays the characters and corresponding Unicodes,
// stops when the end-of-stream is reached.

import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class Keyboard {
    public static void main( String[] args ) throws IOException {
        InputStreamReader in = new InputStreamReader( System.in );
        int num = 0;
        char[] buffer = new char[256];
        Arrays.fill(buffer, '\u0000');

        while ( num != -1 ) {
            in.read(buffer);
            String str = new String(buffer);
            str = str.trim();
            System.out.println("Buffer: " + str);
            Arrays.fill(buffer, '\u0000');
        }
        System.out.println( "bye" );
    }
}

// > java Keyboard
// On Unix you must type control-d in order to send an eos (-1) to
// the program.