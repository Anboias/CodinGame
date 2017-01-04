import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        int[][] tab = new int[L][2];
        int[] EI = new int[E];
        for (int i = 0; i < L; i++) {
            tab[i][0] = in.nextInt();
            tab[i][1] = in.nextInt();
        }
        for (int i = 0; i < E; i++)
            EI[i] = in.nextInt(); // the index of a gateway node        
        while (true) {
            int s = 0;
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            for (int j = 0; j < L; j++){
                for (int m = 0; m < E; m++){
                    if ( (tab[j][0] == EI[m] || tab[j][1] == EI[m]) && (tab[j][0] == SI || tab[j][1] == SI) ){
                        L -= 1;
                        System.out.println(tab[j][0] + " " + tab[j][1]);
                        tab[j][0] = tab[L][0];
                        tab[j][1] = tab[L][1];
                        j = L;
                        m = E;
                        s = 1;
                    }
                }
            }
            if (s != 1)
                System.out.println(tab[0][0] + " " + tab[0][1]);
        }
    }
}