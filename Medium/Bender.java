import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    public static int x, y, L, C, loopCounter, dirIndex;
    public static boolean reverse, breaker, obstacle, firstHit;
    public static char[][] map;
    public static String[] directions;
    public static String direction;
    public static List<String> answer;
    
    public static void constructorSolution () {
        directions = new String[]{"SOUTH", "EAST", "NORTH", "WEST"};
        direction = "SOUTH"; 
        dirIndex = 0;
        answer = new ArrayList<>();      
        reverse = false;
        breaker = false;
        obstacle = false;
        firstHit = true;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        L = in.nextInt();
        C = in.nextInt();
        in.nextLine();
        map = new char[L][C];
        for (int i = 0; i < L; i++)
            map[i] = in.nextLine().toCharArray();
        constructorSolution();      // had trouble with classic constructor, so I improvised and made it a method instead
        findCharOnMap('@', -1, -1); // find start position
        while (true) {
            moveBender();
            loopCounter++;
            if (loopCounter > 500)
                break;
        }
        System.out.println("LOOP");
    }
    
    public static void moveBender(){
        int tempY = 0, tempX = 0;
        
        if      (direction.equals("SOUTH")) {tempY++;}
        else if (direction.equals("EAST"))  {tempX++;}
        else if (direction.equals("NORTH")) {tempY--;}
        else if (direction.equals("WEST"))  {tempX--;}
        
        move(y+tempY, x+tempX);
    }

    public static void move(int YY, int XX) {
        char temp = map[YY][XX];
        char dir = '-';
        obstacle = false;

        switch (temp) {
            case '#': 
                obstacle = true;
                break;
            case 'X':
                if (breaker == true) map[YY][XX] = ' ';
                else obstacle = true;
                break;
            case 'B':
                breaker ^= true;
                break;
            case 'I':
                reverse ^= true;
                break;
            case 'T':
                dir = temp;
                break;
            case 'S': case 'E': case 'W': case 'N':
                dir = temp;
                break;
            case '$':
                updateDirection(dir, YY, XX);
                printAnswerAndExit();
            default:
                break;
        }
        updateDirection(dir, YY, XX);
    }
    
    public static void updateDirection(char dir, int YY, int XX) {
        if      (dir == 'S') dirIndex = 0;
        else if (dir == 'E') dirIndex = 1;
        else if (dir == 'N') dirIndex = 2;
        else if (dir == 'W') dirIndex = 3;
        
        if (obstacle == true) {
            if (firstHit == true) {
                dirIndex = reverse == false? 0:3;
                firstHit = false;
            }
            else {
                dirIndex = (dirIndex + (reverse == false ? 1 : 3)) % 4;
            }
        }
        else {
            answer.add(direction);
            if (dir == 'T') {
                findCharOnMap('T', XX, YY);
            }
            else {
                y = YY;
                x = XX;
            }
            obstacle = false;
            firstHit = true;
        }
        direction = directions[dirIndex];
    }
        
    public static void printAnswerAndExit() {
        for (String l : answer)
            System.out.println(l);     
        System.exit(0);
    } 
    
    public static void findCharOnMap(char toFind, int XX, int YY) {
        for (int i = 0; i < L ; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == toFind && (j != XX || i != YY)) {
                    x = j;
                    y = i;
                    return;
                }
            }
        }        
    }
}