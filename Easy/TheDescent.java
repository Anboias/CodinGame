import java.util.*;

class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int j = 0;            
        while (true) {
            int max = 0;
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt();
                if (mountainH > max){
                    max = mountainH;
                    j = i;
                }
            }
            System.out.println(j);
        }
    }
}