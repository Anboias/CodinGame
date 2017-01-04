import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Genome obj = new Genome();
        obj.run();
    }
}

class Genome {    
    private int N, answer, ctr;
    ArrayList<String> subseq;
    
    public Genome () {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        answer = Integer.MAX_VALUE;
        subseq = new ArrayList<String>();        
        for (int i = 0; i < N; i++) {
            subseq.add(in.next());
        }
    }
    
    public void run() {
        ArrayList<ArrayList<String>> allMutation;

        allMutation = generatePerm(subseq);
        getGenomeSeq(allMutation);
    
        System.out.println(answer);
        
    }
        
    public ArrayList<ArrayList<String>> generatePerm(ArrayList<String> original) {
        ctr++;
        if (original.size() == 0) {
            ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
            result.add(new ArrayList<String>());
            return result;  
        }
        
        String firstElement = original.remove(0);

        ArrayList<ArrayList<String>> returnValue = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> permutations = generatePerm(original);        

        for (ArrayList<String> smallerPermutated : permutations) {
            for (int index = 0; index <= smallerPermutated.size(); index++) {
                ArrayList<String> temp = new ArrayList<String>(smallerPermutated);
                temp.add(index, firstElement);
                returnValue.add(temp);
            }
        }       
        return returnValue;    
    }
   
    public void getGenomeSeq(ArrayList<ArrayList<String>> list) {   
        for (ArrayList<String> eachList : list) { 
            
            String firstStr = eachList.get(0);
            for (int i = 1; i < eachList.size(); i++) {
                String nextStr = eachList.get(i);     
                boolean itsOk = false;
                
                for (int k = nextStr.length()-1; k > 0; k--) {
                    if (firstStr.equals(nextStr) || firstStr.contains(nextStr)) {
                        itsOk = true;
                        break;
                    }
                    String subStr = nextStr.substring(0, k);
                    if (firstStr.endsWith(subStr)) {
                        firstStr += nextStr.substring(k);
                        itsOk = true;
                        break;
                    }
                    
                }
                if (!itsOk) {
                    firstStr += nextStr;
                }
            }
            int ansSize = firstStr.length();
            if (ansSize < answer) {
                answer = ansSize;
            }
        }        
    }
}