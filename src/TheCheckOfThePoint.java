import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheCheckOfThePoint {

    private static BufferedReader bufferedReader;

    protected static BufferedReader getStdInReader() {
        
        if (bufferedReader == null) {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        
        return bufferedReader;
    }
    
    public static String readSingleLine() throws IOException {
        return getStdInReader().readLine();
    }
    
    public static int[] readIntFromLine() throws IOException {
        
        String intsString = readSingleLine();
        String[] intStrings = intsString.split(" +");
        
        int[] ints = new int[intStrings.length];
        for (int i=0 ; i<intStrings.length ; i++) {
            ints[i] = Integer.parseInt(intStrings[i]);
        }
        
        return ints;
    }


    public static void main(String args[]) throws IOException {

        int a = Integer.parseInt(args[0]);
        double m = a / 2.0;
        int x = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);

        int dx = (m - x) > m ? 2 : (m - x) < m ? 0 : 1;
        int dy = (m - y) > m ? 2 : (m - y) < m ? 0 : 1;

        if (dx == 0) {
            System.out.println(dy);
        } else if (dx == 1) {
            if (dy < 2) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else if (dx == 2) {
            System.out.println(2);
        } else {
            System.out.println("Error: " + dx + ":" + dy);
        }
    }
}
