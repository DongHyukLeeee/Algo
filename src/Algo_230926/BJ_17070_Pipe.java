package Algo_230926;

import java.util.*;

import Algo_230921.Sample_Dikstra;

import java.io.*;

public class BJ_17070_Pipe {
	static int di[] = { 0, 1, 1 };
	static int dj[] = { 1, 0, 1 };
	static int[][] map;
	static int N, cnt;

	static class Point {
		int x, y,dir;

		public Point(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}



	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		cnt = 0;
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
		
		System.out.println(cnt);

	}

	static void bfs() {
//		boolean isvistied[][] = new boolean[N][N];
//		isvistied[0][1] = true;

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 1, 0));

		while (!q.isEmpty()) {
			Point currPoint = q.poll();
			int currx = currPoint.x;
			int curry = currPoint.y;
			int currdir = currPoint.dir;
			if (currx == N - 1 && curry == N - 1) {
				cnt++;
			}
			for (int i = 0; i < 3; i++) {
				if(currdir==0&&i==1) continue;
				if(currdir==1&&i==0) continue;
				
				if (i == 2) {
				    if (currx + 1 >= N) continue;
				    if (curry + 1 >= N) continue;
				    if (map[currx + 1][curry] == 1 || map[currx][curry + 1] == 1 || map[currx + 1][curry + 1] == 1) {
				        continue;
				    }
				}
				int ni = currx + di[i];
				int nj = curry + dj[i];
				if (ni < 0 || nj < 0 || ni >= N || nj >= N)
					continue;
				if (map[ni][nj] == 0) {
					q.add(new Point(ni, nj, i));
				}
			}

		}

	}

	static String input = "5\r\n"
			+ "0 0 1 0 0\r\n"
			+ "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n"
			+ "0 0 0 0 0\r\n"
			+ "0 0 0 0 0";
}