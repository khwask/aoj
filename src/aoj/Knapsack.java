package aoj;

import java.util.Scanner;

public class Knapsack {

    public static int N;
    public static int W;
    public static int[] v;
    public static int[] w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sp = s.split(" ");
        N = Integer.parseInt(sp[0]);
        W = Integer.parseInt(sp[1]);
        v = new int[N];
        w = new int[N];
        for (int i = 0; i < N; i++) {
            s = sc.nextLine();
            sp = s.split(" ");
            v[i] = Integer.parseInt(sp[0]);
            w[i] = Integer.parseInt(sp[1]);
        }
        sc.close();
        System.out.println(maxValue(0, W));
    }

    public static int maxValue(int i, int j) {
        if (i == N) {
            return 0;
        } else if (j < w[i]) {
            return maxValue(i + 1, j);
        } else {
            return Integer.max(maxValue(i + 1, j), maxValue(i + 1, j - w[i]) + v[i]);
        }
    }
}
