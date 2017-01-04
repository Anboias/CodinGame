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
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine().toUpperCase();
        int[] ascci = new int[T.length()];
        String[] strArray = new String[H];
        for (int i = 0; i < H; i++)
            strArray[i] = in.nextLine();
        int len = T.length();
        for (int j = 0; j < len; j++)
            ascci[j] = (int) T.charAt(j);   
        for (int m = 0; m < H; m++) {
            for (int s = 0; s < len; s++){
                for (int l = 0; l < L; l++){
                    if (ascci[s] >= 65 && ascci[s] <= 90)
                        System.out.print(strArray[m].charAt((ascci[s] - 65) * L + l));
                    else
                        System.out.print(strArray[m].charAt(26 * L + l));
                }
            }
            System.out.println();
        }
    }
}