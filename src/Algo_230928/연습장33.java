package Algo_230928;

import java.util.*;
import java.io.*;

public class 연습장33 {
	static int p[];

	static void union(int a, int b) {
		p[find(b)] = find(a);
	}

	static int find(int a) {
		if (a != p[a]) {
			p[a] = find(p[a]);
		}
		return p[a];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt();
		p = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		Double stars[][] = new Double[V + 1][2];

		for (int i = 1; i <= V; i++) {
			stars[i][0] = sc.nextDouble();
			stars[i][1] = sc.nextDouble();
		}

		Double[][] dis = new Double[V * (V - 1) / 2][3];
		int k = 0;
		for (int i = 1; i <= V; i++) {
			for (int j = i + 1; j <= V; j++) {
				Double a = stars[i][0];
				Double b = stars[i][1];
				Double c = stars[j][0];
				Double d = stars[j][1];
				dis[k][0] = (double) i;
				dis[k][1] = (double) j;

				// 거리 계산 및 저장
				Double distance = Math.pow((a - c) * (a - c) + (b - d) * (b - d), 0.5);
				dis[k][2] = distance;
				k++;
			}
		}

		Double res = 0.0;
		int cnt = 0;
		Arrays.sort(dis, (o1, o2) -> Double.compare(o1[2], o2[2]));

		for (int i = 0; i < V * (V - 1) / 2; i++) {
			int a = dis[i][0].intValue();
			int b = dis[i][1].intValue();
			Double c = dis[i][2];
			
			if(find(a)!=find(b)) {
				union(a, b);
				
				res+=c;
				cnt++;
			}
			if(cnt==V-1) {
				break;
			}

			
			
	

		}

		System.out.println(res);
	}

	static String input = "3\r\n" + "1.0 1.0\r\n" + "2.0 2.0\r\n" + "2.0 4.0";
}
