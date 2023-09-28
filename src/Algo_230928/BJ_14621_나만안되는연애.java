package Algo_230928;

import java.util.*;

public class BJ_14621_나만안되는연애 {
    static int p[];

    static int find(int a) {
        if (a != p[a]) {
            p[a] = find(p[a]);
        }
        return p[a];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) {
            p[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(inputString);

        int V = sc.nextInt();
        int E = sc.nextInt();
        p = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            p[i] = i;
        }
        int gender[] = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            String temp = sc.next();
            gender[i] = temp.charAt(0) - 'A';
        }

        int[][] Edges = new int[E][3];

        for (int i = 0; i < E; i++) {
            Edges[i][0] = sc.nextInt();
            Edges[i][1] = sc.nextInt();
            Edges[i][2] = sc.nextInt();

        }

        Arrays.sort(Edges, (a, b) -> a[2] - b[2]);
        int res = 0, cnt = 0;
        for (int i = 0; i < E; i++) {
            int a = Edges[i][0];
            int b = Edges[i][1];
            int c = Edges[i][2];

            if (gender[a] != gender[b] && find(a) != find(b)) {
                union(a, b);
                res += c;
                cnt++;
            }
            if (cnt == V - 1) {
                break;
            }

        }
        if (cnt!=V-1) {
            res = -1;
        }
        System.out.println(res);
    }

    static String inputString = "5 7\r\n"
            + "M W W W M\r\n"
            + "1 2 12\r\n"
            + "1 3 10\r\n"
            + "4 2 5\r\n"
            + "5 2 5\r\n"
            + "2 5 10\r\n"
            + "3 4 3\r\n"
            + "5 4 7";

    static String inputString2 = "4 4\r\n"
            + "M W M W\r\n"
            + "1 2 1\r\n"
            + "2 3 1\r\n"
            + "3 4 1\r\n"
            + "1 4 2";
}
