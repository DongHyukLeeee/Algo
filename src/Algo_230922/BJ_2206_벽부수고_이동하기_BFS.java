package Algo_230922;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2206_벽부수고_이동하기_BFS {
	static int N, M;
	static int res = Integer.MAX_VALUE;
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, -1, 1 };
	static boolean visited[][][];
	static int map[][];

	static class Point {
		int x, y, wall, cnt;

		public Point(int x, int y, int wall, int cnt) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.cnt = cnt;
		}

	}// Class Point

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		visited = new boolean[N][M][2];
//		dfs(map, 0, 0, 1, 0);

		System.out.println(bfs(map, 0, 0));
	}

	static int bfs(int[][] arr, int startI, int startJ) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startI, startJ, 0, 1));
		visited[startI][startJ][0] = true;

		while (!q.isEmpty()) {
			Point current = q.poll();
			int x = current.x;
			int y = current.y;
			int cnt = current.cnt;
			int wall = current.wall;

			if (x == N - 1 && y == M - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {

				int nx = x + di[i];
				int ny = y + dj[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < M ) {
					if (map[nx][ny] ==0) {
						if(!visited[nx][ny][wall]) {
						q.add(new Point(nx, ny, wall, cnt + 1));
						visited[nx][ny][wall] = true;}
					} 
					else if (map[nx][ny] == 1 ) {
						if(wall==0&& !visited[nx][ny][1]) {
						q.add(new Point(nx, ny, 1, cnt + 1));
						visited[nx][ny][1] = true;
						}
					}
				}
			}
			
		}
		if (res == Integer.MAX_VALUE) {
			res = -1;
		}
		return res;

	}

	static String input = "9 9\r\n" + "010001000\r\n" + "010101010\r\n" + "010101010\r\n" + "010101010\r\n"
			+ "010101010\r\n" + "010101010\r\n" + "010101010\r\n" + "010101011\r\n" + "000100010";

}
