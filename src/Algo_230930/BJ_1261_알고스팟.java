package Algo_230930;

import java.util.*;

import java.io.*;

public class BJ_1261_알고스팟 {
	static int N, M;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int dist[][];
	static int mini = Integer.MAX_VALUE;

	static class point {
		int x, y, cnt;

		public point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		int res = bfs(0, 0);

		System.out.println(res);
	}

	static int bfs(int starti, int startj) {
		PriorityQueue<point> pq = new PriorityQueue<>((a,b)->Integer.compare(a.cnt, b.cnt));
		pq.add(new point(starti, startj, 0));
		dist[starti][startj]=0;
		
		while(!pq.isEmpty()) {
			point cur = pq.poll();
			int curi = cur.x;
			int curj = cur.y;
			int curcnt = cur.cnt;
			
			if(dist[curi][curj]<curcnt) continue;
			
			if(curi==N-1&&curj==M-1) {
				return curcnt;
			}
			
			for(int i=0; i<4; i++) {
				int ni = curi+di[i];
				int nj = curj+dj[i];
				if(ni<0||nj<0||ni>=N||nj>=M) continue;
				int nextcnt = curcnt+ map[ni][nj];
				if(nextcnt<dist[ni][nj]) {
					dist[ni][nj] = nextcnt;
					pq.add(new point(ni,nj,nextcnt));
				}
			}
			
		
		}
		
		
		
		
		return -1;
	}

	static String input = "3 3\r\n" + "011\r\n" + "111\r\n" + "110";
	static String input2 = "4 2\r\n" + "0001\r\n" + "1000";
	static String input3 = "6 6\r\n" + "001111\r\n" + "010000\r\n" + "001111\r\n" + "110001\r\n" + "011010\r\n"
			+ "100010";
}