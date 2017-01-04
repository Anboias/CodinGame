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
        int N = in.nextInt();
        int N2 = N;
        int C = in.nextInt();
        int[] B = new int[N];
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = in.nextInt();
        }
        Arrays.sort(B);
        
        for (int i = 0; i < N2; i++)
        {
            if (B[i] < C/N)
            {
                s[i] = B[i];
                C -= B[i];
            }
            else
            {
                s[i] = C/N;
                C -= C/N;
            }
            N--;
        }  
        if (C > 0)
            System.out.println("IMPOSSIBLE");
        else{
            for (int i = 0; i < N2; i++)
                System.out.println(s[i]);
        }
    }
}