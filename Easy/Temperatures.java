import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        int temp = Integer.MAX_VALUE;
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        
        String[] strArray = temps.split(" ");
        int[] intArray = new int[strArray.length];
        
        if(temps.length() != 0){
            for(int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            for(int x : intArray){
                if (Math.abs(x) < Math.abs(temp)){
                    temp = x;                
                }
                if (Math.abs(x) == Math.abs(temp) && x > temp){
                    temp = x;
                }
            }
        }
        else
            temp = 0;
        System.out.println(temp);
        

    }
}