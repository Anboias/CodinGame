import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static String strC = "";
    
    public static void toBinary(int int1){
        String temp;
        temp = Integer.toBinaryString(int1);
        while (temp.length() < 7)
            temp = "0" + temp;
        strC += temp;       
    }
    
    public static void toChuck(){    
        int z = 1;
        String toPrint;
        
        if (strC.charAt(0) == '0')
            toPrint = "00 0";
        else
            toPrint = "0 0";    
        while (z < strC.length()){
            if (strC.charAt(z) == '0'){
                if (strC.charAt(z - 1) == '0')
                    toPrint += "0";
                else{
                    System.out.print(toPrint + " ");
                    toPrint = "00 0";
                }
            }
            else{
                if (strC.charAt(z - 1) == '1')
                    toPrint += "0";
                else{
                    System.out.print(toPrint + " ");
                    toPrint = "0 0";
                }
            }
            z++;
        }
        System.out.println(toPrint);       
    }
 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();     
        
        byte[] bytes = MESSAGE.getBytes();    
        for (int x : bytes)
            toBinary(x);
        toChuck();    
    }
}