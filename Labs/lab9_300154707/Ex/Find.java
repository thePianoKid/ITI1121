// Prints all the lines containing a given word. For each line
// containing the word, it prints the line number followed by the line
// itself.

import java.io.*;

public class Find {

    public static void find( String fileName, String word ) 
        throws IOException, FileNotFoundException {

		BufferedReader input;

        input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        
        int lineNumber = 0;
        String line;
        
        line = input.readLine();
        while(line != null) {
            if (line.indexOf(word) != -1) {
                System.out.println(lineNumber + ": " + line);
            }
            line = input.readLine();
            lineNumber++;
        }

        input.close();
		
    }

    public static void main( String[] args ) 
        throws IOException, FileNotFoundException {

        if ( args.length != 2 ) {
            System.out.println( "Usage: java Find file word" );
            System.exit( 0 );
        }

        find( args[0], args[1] );

    }
}


//output example
// > java Find Find.java IOException
// 10:   throws IOException, FileNotFoundException {
// 28:  throws IOException, FileNotFoundException {