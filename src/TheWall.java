import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheWall {

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

    public static void main(String[] args) throws IOException {

        int[] inputs = readIntFromLine();
            
        int R = inputs[0];
        String input = null;
        for (int i=0 ; i<R ; i++)
            input = readSingleLine();

        int count = 0;
        boolean[] inSegment = { false };

        for (int i=0; i<input.length(); i++)
            if (isTransitioningOut(input.charAt(i), inSegment))
                count++;

        if (isTransitioningOut('.', inSegment))
             count++;

        System.out.println(count);
    }

    private static boolean isTransitioningOut(char current, boolean[] inSegmentArray) {
        boolean transitioningOut = false;
        boolean inSegment = inSegmentArray[0];

        if (current == 'B') {
            if (! inSegment) {
                inSegmentArray[0] = true;
            }
        } else if (current == '.') {
            if (inSegment) {
                inSegmentArray[0] = false;
                transitioningOut =  true;
            }
        }

        return transitioningOut;
    }
}
