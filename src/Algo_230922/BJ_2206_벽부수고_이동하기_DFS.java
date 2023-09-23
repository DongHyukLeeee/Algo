package Algo_230922;

import java.util.Scanner;

public class BJ_2206_벽부수고_이동하기_DFS {
	static int N, M;
	static int res = Integer.MAX_VALUE;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static boolean visited[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		N = sc.nextInt();
		M = sc.nextInt();

		int map[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		visited = new boolean[N][M];
//		dfs(map, 0, 0, 1, 0);
		
		if(res==Integer.MAX_VALUE) {
			res=-1;
		}
		System.out.println(res);
	}

	static void dfs(int[][] map, int ii, int jj, int cnt, int used1) {
		if (used1 == 2) {
			return;
		}
		if ((ii == N - 1) && (jj == M - 1)) {
			res = Math.min(res, cnt); 
			return;
		} else {
			visited[ii][jj] = true;
			for (int k = 0; k < 4; k++) {

				int ni = ii + di[k];
				int nj = jj + dj[k];
				if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 1&&!visited[ni][nj]) {
					dfs(map, ni, nj, cnt + 1, used1 + 1);
				} else if (ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 0&&!visited[ni][nj]) {
					dfs(map, ni, nj, cnt + 1, used1);
				}

			}
			visited[ii][jj] = false;
		}

	}

	static String input =
"4 4\r\n"
+ "0111\r\n"
+ "1111\r\n"
+ "1111\r\n"
+ "1110";
}
