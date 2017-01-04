import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * to myself: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt();
        
        String temp = "";
        if (initialTY > lightY) { temp += "N"; initialTY--; };
        if (initialTY < lightY) { temp += "S"; initialTY++; };
        if (initialTX > lightX) { temp += "W"; initialTX--; };
        if (initialTX < lightX) { temp += "E"; initialTX++; };
        System.out.println(temp);

        }
    }
}