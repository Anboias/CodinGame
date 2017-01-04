import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(), H = in.nextInt(), N = in.nextInt();
        int X0 = in.nextInt(), Y0 = in.nextInt();
        int I = 0, L = 0;
        
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            if (bombDir.indexOf("U") >= 0) { H = Y0; Y0 = I + (H - I)/2; }
            if (bombDir.indexOf("D") >= 0) { I = Y0; Y0 = I + (H - I)/2; }
            if (bombDir.indexOf("L") >= 0) { W = X0; X0 = L + (W - L)/2; }
            if (bombDir.indexOf("R") >= 0) { L = X0; X0 = L + (W - L)/2; }
            System.out.println(X0 + " " + Y0);
        }                   
    }
}