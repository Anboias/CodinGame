import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Double longA = Double.parseDouble(in.next().replace(",","."));
        Double latA = Double.parseDouble(in.next().replace(",","."));  
        int N = in.nextInt(); in.nextLine();
        
        Double distance = Double.MAX_VALUE;
        String toPrint = "";
        
        for (int i = 0; i < N; i++){
            String[] defib = in.nextLine().split(";");
            Double longB = Double.parseDouble(defib[4].replace(",","."));
            Double latB = Double.parseDouble(defib[5].replace(",","."));
            Double x = (longB - longA) * Math.cos((latA + latB) * 0.5);
            Double y = latB - latA;
            Double d = Math.sqrt(x * x + y * y);
            if (d < distance) { distance = d; toPrint = defib[1]; }
        }        
        System.out.println(toPrint);
    }
}