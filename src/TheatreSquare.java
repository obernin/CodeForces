

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheatreSquare {
    
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
        
            int[] inputs = readIntFromLine();
            
            int n = inputs[0];
            int m = inputs[1];
            int a = inputs[2];
            
            long na = n / a + (n % a != 0 ? 1 : 0);
            long ma = m / a + (m % a != 0 ? 1 : 0);
            
            System.out.println(na * ma);
    }
}   

