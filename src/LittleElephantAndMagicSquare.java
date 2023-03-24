import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleElephantAndMagicSquare {

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

        /*
         * https://codeforces.com/problemset/problem/259/B
         * 
         * The problem has a formal solution.
         * 
         * Consider the input (x, y, z unknonw)
         *   x a b
         *   c y d
         *   e f z
         * 
         * Because it's a magix square:
         * x + a + b = N (1)
         * c + y + d = N (2)
         * e + f + z = N (3)
         * x + y + z = N (4)
         * 
         * If you add (1), (2) and (3) you get x + a + b + c + y + d + e + f + z = 3N
         * If you substract (4) you get a + b + c + d + e + f = 2N
         * 
         * You can compute N and then trivially find x, y & z from (1), (2) & (3) respectively 
         */        
        
        int[] inputs = readIntFromLine();
        int x = inputs[0];
        int a = inputs[1];
        int b = inputs[2];
        
        inputs = readIntFromLine();
        int c = inputs[0];
        int y = inputs[1];
        int d = inputs[2];
        
        inputs = readIntFromLine();
        int e = inputs[0];
        int f = inputs[1];
        int z = inputs[2];
        
        long N = (a + b + c + d + e + f) / 2;

        System.out.println(String.format("%d %d %d\n%d %d %d\n%d %d %d",
        N - (a + b), a, b, c, N - (c + d), d, e, f, N - ( e +  f)));
    }
}   

