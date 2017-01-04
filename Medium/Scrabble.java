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
        in.nextLine();
        String[] W = new String[N];
        for (int i = 0; i < N; i++) {
            W[i] = in.nextLine();
        }
        int biggest = 0;
        int point = 0, temp = 0;
        String LETTERS = in.nextLine();
        HashMap<Character, Integer> let = new HashMap<Character, Integer>();
        values(let);
        int total = 0, max = 0, pozWord = 0;;      
     
        for (int i = 0; i < N; i++){
            String used = "";
            for (int k = 0; k < W[i].length(); k++){
                if(LETTERS.indexOf(W[i].charAt(k)) == -1 || (W[i].length() > LETTERS.length())){
                    total = 0;
                    break;
                }
                else{
                    if (let.containsKey(W[i].charAt(k))){
                        char c = W[i].charAt(k);
                        if (used.indexOf(c) > -1 && LETTERS.lastIndexOf(c) == LETTERS.indexOf(c)){
                            total = 0;
                            break;
                        }
                        used += c;
                        temp = let.get(c);
                        total += temp;
                    }
                }
            }                    
            if (total > max){
                max = total;
                pozWord = i;
            }
            total = 0;
        }
        System.out.println(W[pozWord]);
    }
    public static void values(HashMap let){
        let.put('a', 1);
        let.put('b', 3);
        let.put('c', 3);
        let.put('d', 2);
        let.put('e', 1);
        let.put('f', 4);
        let.put('g', 2);
        let.put('h', 4);
        let.put('i', 1);
        let.put('j', 8);
        let.put('k', 5);
        let.put('l', 1);
        let.put('m', 3);
        let.put('n', 1);
        let.put('o', 1);
        let.put('p', 3);
        let.put('q', 10);
        let.put('r', 1);
        let.put('s', 1);
        let.put('t', 1);
        let.put('u', 1);
        let.put('v', 4);
        let.put('w', 4);
        let.put('x', 8);
        let.put('y', 4);
        let.put('z', 10); 
    }
}