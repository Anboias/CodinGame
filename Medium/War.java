import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        int size = n*2 + 1;
        int p1[] = new int[size];
        int p2[] = new int[size];
        int w1[] = new int[size];
        int w2[] = new int[size];
        int PAT = 0, a = 0, res = 0, ctr = 0, ctr2 = 0;        
        for (int i = 0; i < n; i++) p1[i] = transform(in.next()); // the n cards of player 1
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) p2[i] = transform(in.next()); // the m cards of player 2
        
        while (ctr < size){
            ctr = 0;
            res = compare(p1[0], p2[0]);
            if (res == 1 || res == 2) ctr = size;
            else if (res == 3) { n = update(p1, p2, p1, n, m, size, w1, w2); m--; a = 0; }
            else if (res == 7) { m = update(p1, p2, p2, m, n, size, w1, w2); n--; a = 0; }
            else if (res == 9) { PAT = war(p1, p2, w1, w2, a, size); a += 4; m -= 4; n -= 4; }
            else if (ctr2 == 1000) System.out.println("PAT");           
            if (a >= 4)     
                ctr2--;
            if (PAT == -1) 
                ctr2 = 999; 
            ctr2++;
            ctr++;
        }            
        if (ctr2 != 1000) 
            System.out.println(res + " " + (ctr2-1));
        else
            System.out.println("PAT");
    }
    public static int update(int p1[], int p2[], int winner[], int w, int l, int size, int w1[], int w2[]){
        for (int j = 0; w1[j] > 0; j++){
            winner[w] = w1[j];
            w1[j] = 0;
            w++;
        }
        winner[w] = p1[0];
        w++;
        for (int j = 0; w2[j] > 0; j++){
            winner[w] = w2[j];
            w2[j] = 0;
            w++;
        }
        winner[w] = p2[0];
        for (int k = 0; k < size - 1; k++){
            p1[k] = p1[k + 1];
            p2[k] = p2[k + 1];
        }
        return w;
    }
    public static int war(int[] p1, int[] p2, int[] w1, int[] w2, int a, int size){
        int j = 0, PAT = 0;
        for (int i = a; i < a + 4; i++){
            w1[i] = p1[j];
            w2[i] = p2[j];
            if (p1[j] == 0 || p2[j] == 0)
                PAT = -1;
            j++;
        }
        for (int k = 0; k < size - 4; k++){
            p1[k] = p1[k + 4];
            p2[k] = p2[k + 4];
        }
        return PAT;
    }
    public static int compare(int p1, int p2){
        if      (p1 == 0)   return 2;
        else if (p2 == 0)   return 1;
        else if (p1 > p2)   return 3;
        else if (p1 < p2)   return 7;
        else if (p1 == p2)  return 9;
        else 
            return -1;
    }
    public static int transform(String str){       
        if      (str.indexOf("2") >= 0)  return 2;
        else if (str.indexOf("3") >= 0)  return 3;
        else if (str.indexOf("4") >= 0)  return 4;
        else if (str.indexOf("5") >= 0)  return 5;
        else if (str.indexOf("6") >= 0)  return 6;
        else if (str.indexOf("7") >= 0)  return 7;
        else if (str.indexOf("8") >= 0)  return 8;
        else if (str.indexOf("9") >= 0)  return 9;        
        else if (str.indexOf("10") >= 0) return 10;
        else if (str.indexOf("J") >= 0)  return 11;
        else if (str.indexOf("Q") >= 0)  return 12;        
        else if (str.indexOf("K") >= 0)  return 13;         
        else if (str.indexOf("A") >= 0)  return 14;
        else 
            return 0;
    }
}