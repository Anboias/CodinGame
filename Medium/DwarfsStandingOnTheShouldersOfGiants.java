import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    static class Influences {
        private Map<Integer, People> influencesMap;
        
        public Influences() {
            influencesMap = new HashMap<Integer, People>();
        }
        
        public void addRelationship(int x, int y) {
            People giant = getPeople(x);
            People dwarf = getPeople(y);
            
            giant.addInfluenced(dwarf);
            dwarf.addInfluencedBy(giant);
        }
        
        public int getLongestInfluenceLength() {
            return getGiant().getLongestInfluenceLength();
        }
        
        private People getPeople(int id) {
            People people = influencesMap.get(id);
            if (people == null) {
                people = new People();
                influencesMap.put(id, people);
            }
            return people;
        }
        
        private People getGiant() {
            People giant = null;
            
            for (People people :influencesMap.values()) {
                if (people.influencedByList.isEmpty()) {
                    giant = people;
                    break;
                }
            }
            return giant;
        }
    } 
    static class People {
        private List<People> influencedList;
        private List<People> influencedByList;
        
        public People() {
            this.influencedList = new ArrayList<People>();
            this.influencedByList = new ArrayList<People>();
        }
        public void addInfluenced(People influenced){
            influencedList.add(influenced);
        }
        public void addInfluencedBy(People influenced){
            influencedByList.add(influenced);
        }
        
        public int getLongestInfluenceLength() {
            int longestInfluenceLength = 0;
            
            for (People influenced : influencedList) {
                longestInfluenceLength = Math.max(longestInfluenceLength, influenced.getLongestInfluenceLength());
            }
            return longestInfluenceLength + 1;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of relationships of influence
        Influences influences = new Influences();

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            influences.addRelationship(x, y);
        }
        System.out.println(influences.getLongestInfluenceLength());
    }
    
}