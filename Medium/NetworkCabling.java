import java.util.*;
import java.math.*;
import java.io.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<Long> yy = new ArrayList();
        long max = Long.MIN_VALUE; 
        long min = Long.MAX_VALUE;
        long result = 0;
        for (int i = 0; i < N; i++) {
            long X = in.nextInt();
            long Y = in.nextInt();
            yy.add(Y);
            if (X > max) max = X;
            if (X < min) min = X;
        }
        Collections.sort(yy);
        long med = yy.get(N/2);
        
        for (long t : yy)
            result += Math.abs(t - med);
            
        System.out.println(result+max-min);
    }
}