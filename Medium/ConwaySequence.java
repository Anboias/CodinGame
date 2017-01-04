import java.util.*;
import java.io.*;
import java.math.*;
import java.util.stream.Collectors;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();
        
        List<Integer> l = new ArrayList<>();
        
        getNext(R, L);
    }
    public static void getNext(int first, int lines){
        List<Integer> currentLine = new ArrayList<>();
        currentLine.add(Integer.valueOf(first));

        for (int i = 2; i <= lines; i++){
            currentLine = getLast(currentLine);
        }
        printLine(currentLine);
    }
    public static List<Integer> getLast(List<Integer> currentLine){
        List<Integer> nextLine = new ArrayList<>();
        
        int startIndex = 0, nextIndex = 1;
        while(nextIndex < currentLine.size()){
            if (currentLine.get(startIndex) != currentLine.get(nextIndex)){
                nextLine.add(nextIndex-startIndex);
                nextLine.add(currentLine.get(startIndex));
                startIndex = nextIndex;
            }
            nextIndex++;
        }
        nextLine.add(nextIndex-startIndex);
        nextLine.add(currentLine.get(startIndex));
        
        return nextLine;
    }
    private static void printLine(List<Integer> sequenceLine) {
		System.out.println(sequenceLine.stream().map(i -> i.toString()).collect(Collectors.joining(" ")));
	}
}