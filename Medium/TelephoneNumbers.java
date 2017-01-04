import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static int counter = 0;
    public static class Trie{
        char c;
        Trie[] children;
        boolean phoneNumber;
        
        public Trie(){
            this.c = c;
            this.children = new Trie[10];
            this.phoneNumber = false;
        }      
        public void add(String s){
            if(s.isEmpty()){
                this.phoneNumber = true;
                return;
            }
            counter++;
            char number = s.charAt(0);
            int index = number - '0';            
            if(this.children[index] == null){
                this.children[index] = new Trie();
            }
            else{
                counter--;
            }
            this.children[index].add(s.substring(1));
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] telephone = new String[N];
        for (int i = 0; i < N; i++) {
            telephone[i] = in.next();
        }
        Trie number = new Trie();
        for (int i = 0; i < N; i++)
            number.add(telephone[i]);
            
        System.out.println(counter);
    }
}