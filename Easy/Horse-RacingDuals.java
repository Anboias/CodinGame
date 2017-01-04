import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] pi = new int[N];
        for (int i = 0; N > i; N--)
            pi[N - 1] = in.nextInt();
        Arrays.sort(pi);
        int temp = Integer.MAX_VALUE;
        for (int i = 1; i < pi.length; i++)
            if (pi[i] - pi[i - 1] < temp) temp = pi[i] - pi[i - 1];
        System.out.println(temp);
    }
}