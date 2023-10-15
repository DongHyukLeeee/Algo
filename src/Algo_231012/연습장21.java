package Algo_231012;

import java.util.*;

public class 연습장21 {
	static int N, M, K;

	static int[][] map;
	static int di[] = { 0, 0, 1, -1 };
	static int dj[] = { 1, -1, 0, 0 };

	static class point {
		int x, y, cnt, used;



		public point(int x, int y, int cnt, int used) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.used = used;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input4);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {

				map[i][j] = temp.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs());
	}

	static int bfs() {
		Queue<point> queue = new LinkedList<>();
		
		queue.add(new point(0, 0, 1, 0));
		boolean visited[][][] = new boolean[K+1][N][M];
		visited[0][0][0]=true;
		
		while(!queue.isEmpty()) {
			point cur = queue.poll();
			int curx = cur.x;
			int cury = cur.y;
			int curcnt = cur.cnt;
			int curused = cur.used;
			
			if(curx==N-1&&cury==M-1&&curused<=K) {
				return curcnt;
			}
			if(curused>K) continue;
			
			for(int i=0; i<4; i++) {
				int ni = curx+di[i];
				int nj = cury+dj[i];
				if(ni<0||nj<0||ni>=N||nj>=M) continue;
				
				if(!visited[curused][ni][nj]) {
					if(map[ni][nj]==0) {
						visited[curused][ni][nj]=true;
						queue.add(new point(ni, nj, curcnt+1, curused));
					}
					else if(map[ni][nj]==1&&curused<=K-1) {
						visited[curused+1][ni][nj]=true;
						queue.add(new point(ni, nj, curcnt+1, curused+1));

					}
				}
			}
			
		}
		
		return -1;
		
		
	}

	static String input1 = "6 4 1\r\n" + "0100\r\n" + "1110\r\n" + "1000\r\n" + "0000\r\n" + "0111\r\n" + "0000";
	static String input2 = "6 4 2\r\n"
			+ "0100\r\n"
			+ "1110\r\n"
			+ "1000\r\n"
			+ "0000\r\n"
			+ "0111\r\n"
			+ "0000";
	static String input3 = "2 4 2\r\n"
			+ "0111\r\n"
			+ "0110";
	
	static String input4 = "4 4 3\r\n"
			+ "0111\r\n"
			+ "1111\r\n"
			+ "1111\r\n"
			+ "1110";
}