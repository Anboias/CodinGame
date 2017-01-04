import java.util.*;
import java.io.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        String[] line = new String[height];
        for (int i = 0; i < height; i++)
            line[i] = in.nextLine(); // width characters, each either 0 or .
        int temp = 0;
        for (int i = 0; i < height; i++){
            for (int k = 0; k < width; k++){
                if (line[i].charAt(k) == '0'){
                    System.out.printf("%d %d ", k, i);
                    for (temp = k + 1; temp < width; temp++){
                        if (line[i].charAt(temp) == '0'){
                            System.out.printf("%d %d ", temp, i);
                            temp = width;
                        }
                    }
                    if (temp != width + 1) {System.out.print("-1 -1 ");}         
                    for (temp = i + 1; temp < height; temp++){ 
                        if (line[temp].charAt(k) == '0'){
                            System.out.printf("%d %d\n", k, temp);
                            temp = height;
                        }
                    }
                    if (temp != height + 1) {System.out.println("-1 -1");}
                }
            }
        }  
    }
}