import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        Map<String, String> map = new HashMap<String, String>();
        
        for (int i = 0; i < N; i++) { map.put(in.next().toLowerCase(), in.next()); in.nextLine(); }
        
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine().toLowerCase();
            int tmp = FNAME.lastIndexOf(".");
            String ext = tmp == -1 ? "" : FNAME.substring(tmp + 1);
            System.out.println( map.containsKey(ext) ? map.get(ext) : "UNKNOWN");
        }
    }
}