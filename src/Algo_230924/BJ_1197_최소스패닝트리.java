package Algo_230924;

import java.util.*;
import java.io.*;

public class BJ_1197_최소스패닝트리 {

	static int[] p;

	static int find(int x) {
		if (p[x] != x)
		p[x] = find(p[x]);
		return p[x];

	}

	static void union(int x, int y) {
		p[find(y)] = p[find(x)];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		p = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			p[i] = i;
		}
		int E = sc.nextInt();
		int edges[][] = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();

		}
		Arrays.sort(edges, (a, b) -> a[2] - b[2]);
		int cnt = 0;
		int res = 0;
		for (int i = 0; i < E; i++) {
			int n1 = edges[i][0];
			int n2 = edges[i][1];
			int w = edges[i][2];

			if (find(n1) != find(n2)) {
				union(n1, n2);
				res += w;
				cnt++;
			}
			if(cnt==V-1) {
				break;
			}
		}
		System.out.println(res);

	}

	static String input = "3 3\r\n" + "1 2 1\r\n" + "2 3 2\r\n" + "1 3 3";
}