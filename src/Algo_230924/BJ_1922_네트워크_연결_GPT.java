package Algo_230924;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1922_네트워크_연결_GPT {
    static int V, E;
    static int[] p;

    static int set(int x) {
        if (x != p[x]) {
            p[x] = set(p[x]);
        }
        return p[x];
    }

    static void union(int x, int y) {
        if (x < y) {
            p[set(y)] = set(x);
        } else {
            p[set(x)] = set(y);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        p = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }
        int edges[][] = new int[E][3];

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        long ans = 0;
        int pick = 0;

        for (int i = 0; i < E; i++) {

            int x = edges[i][0];
            int y = edges[i][1];
            int wei = edges[i][2];

            if (set(x) != set(y)) {
                union(x, y);
                ans += wei;
                pick++;
            }
            if (pick == V - 1) {
                break;
            }

        }

        System.out.println(ans);
    }
}
