import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    
    public static int[][] map;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] temp = in.nextLine().split(" "); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            for (int k = 0; k < temp.length; k++){
                map[i][k] = Integer.parseInt(temp[k]);            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            int pos = map[YI][XI];
            displayNext(pos, XI, YI, POS);
        }
    }
    public static void displayNext(int pos, int X, int Y, String POS){
        switch (pos) {
            case 1: case 3: case 7: case 8: case 9: case 12: case 13:
                Y++; break;
            case 2: case 6:
                if (POS.equals("RIGHT")) X--; else X++; break;
            case 4:  if (POS.equals("RIGHT")) Y++; else X--; break;
            case 5:  if (POS.equals("LEFT")) Y++; else X++; break;
            case 10: X--; break;
            case 11: X++; break;
            default: break;
        }
        System.out.println(X + " " + Y);
    }
}