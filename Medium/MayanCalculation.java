import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Mayan obj = new Mayan();
        obj.execute();
    }
}

class Mayan {
    private int L, H, S1, S2;
    private String[] numeral, num1Line, num2Line;
    private String operation;
    private Map<String, Integer> mayanNumerals;
    
    public Mayan () {
        Scanner in = new Scanner(System.in);
        L = in.nextInt();
        H = in.nextInt();
        mayanNumerals = new HashMap<>();
        numeral = new String[H];
        for (int i = 0; i < H; i++) {
            numeral[i] = in.next();
        }
        S1 = in.nextInt();
        num1Line = new String[S1];
        for (int i = 0; i < S1; i++) {
            num1Line[i] = in.next();
        }
        S2 = in.nextInt();
        num2Line = new String[S2];
        for (int i = 0; i < S2; i++) {
            num2Line[i] = in.next();
        }
        operation = in.next();
    }
    
    public void execute() {
        List<String> toPrint = new ArrayList<>();
        String result = "";
        long num1, num2, answer;
        
        fillMayanNumerals();
        num1 = getNumber(num1Line, S1);
        num2 = getNumber(num2Line, S2);
        answer = compute(num1, num2);
        if (answer == 0) {
            for (String key : mayanNumerals.keySet()) {
                if (mayanNumerals.get(key) == 0) {
                    result = key;
                    toPrint.add(0, result);
                }
            }
        }
        else {
            while (answer > 0) {
                long temp = answer % 20;
                for (String key : mayanNumerals.keySet()) {
                    if (mayanNumerals.get(key) == temp) {
                        result = key;
                    }
                }
                toPrint.add(0, result);
                answer /= 20;
            }
        }
        for (String str : toPrint) {
            transformToMayanAndPrint(str);
        }
    }
    
    public void transformToMayanAndPrint(String result) {
        for (int i = 0; i < result.length()/H; i++) {
            for (int j = i; j < result.length(); j+=H) {
                System.out.print(result.charAt(j));
            }
            System.out.println();
        }
    }   
    
    public long compute(long num1, long num2) {
        long answer = 0;
        switch (operation) {
            case "+":
                answer = num1 + num2;
                break;
            case "-":
                answer = num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                answer = num1 / num2;
                break;
            default: break;
        }       
        return answer;
    } 
    
    public long getNumber(String[] numLine, int S) {
        long answer = 0;
        String temp = "";
        int counter = S/H - 1;
    
        for (int k = 0; k < S; k+=H) {
            for (int l = 0; l < L; l++) {
                for (int h = 0; h < H; h++) {
                    temp += numLine[h+k].charAt(l);
                }
            }
            long tempNum = mayanNumerals.get(temp);
            answer += (tempNum * Math.pow(20, counter));
            counter--;
            temp = "";
        }
        return answer;
    }    
    
    public void fillMayanNumerals() {
        int k = 0;
        String temp = "";
        for (int l = 0; l < L*20; l++) {
            if (l % L == 0 && l != 0) {
                mayanNumerals.put(temp, k);
                k++;
                temp = "";
            }
            for (int h = 0; h < H; h++) {
                temp += numeral[h].charAt(l);
            }
        }
        mayanNumerals.put(temp, k);
    }
}