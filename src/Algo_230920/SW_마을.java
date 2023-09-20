package Algo_230920;

import java.util.*;

public class SW_마을 {
	static int[] p;
	static int N, M;

	static void union(int x, int y) {
		p[y] = x;
	}//union

	static int findset(int x) {
		if (x != p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}//findset

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int Tcase = sc.nextInt();

		for (int tc = 1; tc <= Tcase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			p = new int[N + 1];
			for (int i = 0; i <= N; i++) {
				p[i] = i;
			}

			int[][] edges = new int[M][2];

			for (int i = 0; i < M; i++) {
				edges[i][0] = sc.nextInt();
				edges[i][1] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				int x = edges[i][0];
				int y = edges[i][1];

				if (findset(x) != findset(y)) {
					union(findset(x), findset(y));
				}
			}
			for (int i = 1; i <= N; i++) {
				findset(i);
			}//부모 초기화
			HashSet<Integer> unique = new HashSet<Integer>();

			for (int i = 1; i <= N; i++) {
				unique.add(p[i]);
			}//해쉬코드에 저장

			System.out.println("#" + tc + " " + unique.size());//해ㅐ쉬코드의 사이즈를 반환
		}

	}
}
