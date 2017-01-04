import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
 
 /*
** I am aware that the approach used in solving this puzzle is very wrong,
** but I didn`t knew better at the time and, anyway, it worked :)
*/
 
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int findFlat = 0, findFlat2 = 0;
        int xRamp = 0, yRamp = 0;
        int asd = 0, sw = 0;
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        int lastX = 0;

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            if (asd == 0){
                findFlat = landY;
                asd = 1;
            }
            else if (asd == 1){
                if (findFlat2 == landY){
                //  System.out.print(landX + " "); 
                //  System.out.println(landY); 
                    xRamp = landX;
                    yRamp = landY;
                }
                findFlat = findFlat2;
                findFlat2 = landY;
            } 
        }

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            if (Y >= yRamp){
            if (X < (xRamp-2000)){
                if (hSpeed < 35)
                    System.out.println("-45 4");
                else
                    System.out.println("30 4");
            }            
            else if (X > xRamp-2000 && X < xRamp - 800){
                if (hSpeed > 20)
                    System.out.println("45 3");
                else if (hSpeed < -20)
                    System.out.println("-45 4");
                else if (hSpeed < 20 && hSpeed > 0 && Math.abs(vSpeed) > 38)
                    System.out.println("0 4");
                else if (hSpeed > -20 && hSpeed < 0 && Math.abs(vSpeed) > 38)
                    System.out.println("-15 4");
                else
                    System.out.println("0 4");
            }
            else if (X > xRamp-800 && X < xRamp-300){
                if (hSpeed > 40)
                    System.out.println("45 4");
                else if (hSpeed < -40)
                    System.out.println("-45 4");
                else if (Math.abs(vSpeed) > 38)
                    System.out.println("0 4");
                else
                    System.out.println("0 2");
            }
            else if (X > xRamp-300 && X < xRamp+1001){
                if (hSpeed > 60)
                    System.out.println("90 4");
                else if (hSpeed < -60)
                    System.out.println("-90 4");
                else if (hSpeed > 20)
                    System.out.println("45 4");
                else if (hSpeed < -20)
                    System.out.println("-43 4");
                else if ((hSpeed > -20 || hSpeed < 20) && Math.abs(vSpeed) > 38)
                    System.out.println("0 4");
                else
                    System.out.println("0 3");
            }
            else if (X > xRamp+1000){
                if (Math.abs(hSpeed) < 35)
                    System.out.println("44 4");
                else if (Math.abs(hSpeed) >= 35)
                    System.out.println("-44 4");
            }
            }
            else
            {
                if (X > xRamp-200){
                    if (hSpeed > -20)
                        System.out.println("0 4");
                    else if (hSpeed <= -20)
                        System.out.println("-15 4");
                }                
                else if (X < xRamp-800){
                    if (hSpeed < 20)
                        System.out.println("0 4");
                    else if (hSpeed >= 20)
                        System.out.println("15 4");
                }
                
            }
            
            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.
            //System.out.println("-20 3");
        }
    }
}