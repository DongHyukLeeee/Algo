package Algo_230924;

import java.util.*;
import java.io.*;

public class BJ_1922_치즈 {
	static int[][] cheeseMap;
	static int M, N;
	static boolean zeroMap[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		N = sc.nextInt();
		M = sc.nextInt();
		cheeseMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cheeseMap[i][j] = sc.nextInt();
			}
		}
		
		int hour;
		for(hour = 0; hour<100; hour++) {
		if(isAllmelted())
			break;
		findvisit0();


		bfs();

		}

		System.out.println(hour);
	}

	static void bfs() {
		boolean visit[][] = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j =0; j < M; j++) {
				if (cheeseMap[i][j] == 1) {
					visit[i][j] = true;
					int cnt = 0;
					for (int k = 0; k <  4; k++) {
						int ni = i + di[k];
						int nj = j + dj[k];
						if (ni < 0 || nj < 0 || ni >= N || nj >= M)
							continue;
						
						if (!visit[ni][nj] &&zeroMap[ni][nj]&& cheeseMap[ni][nj] == 0) {

							cnt++;
						}
					}
					if (cnt >= 2) {
						cheeseMap[i][j]=0;
					}
				}
			}
		}

	}

	static boolean isAllmelted() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(cheeseMap[i][j]!=0)
					return false;
			}
		}
		return true;
	}
	
	static void findvisit0() {
		
		zeroMap = new boolean [N][M];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		zeroMap[0][0]= true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			
			for(int i=0; i<4; i++) {
				int ni = curx + di[i];
				int nj = cury + dj[i];
				if(ni<0||nj<0||ni>=N||nj>=M)
					continue;
				if(!zeroMap[ni][nj]&&cheeseMap[ni][nj]==0) {
					q.add(new Point(ni,nj));
					zeroMap[ni][nj]=true;
				}
			}
			
		}
		
		
	}
	static void changeinsideEmptyto2() {

		for (int k = 0; k < N; k++) {
			for (int l = 0; l < M; l++) {
				if (cheeseMap[k][l] == 0) {
					boolean flag1 = false;
					boolean flag2 = false;
					boolean flag3 = false;
					boolean flag4 = false;

					for (int i = 0; i < k; i++) {
						if (cheeseMap[i][l] == 1) {
							flag1 = true;
						}
					}
					for (int i = k + 1; i < N; i++) {
						if (cheeseMap[i][l] == 1) {
							flag2 = true;
						}
					}
					for (int i = 0; i < l ; i++) {
						if (cheeseMap[k][i] == 1) {
							flag3 = true;
						}
					}
					for (int i = l + 1; i < M; i++) {
						if (cheeseMap[k][i] == 1) {
							flag4 = true;
						}
					}
					if (flag1 && flag2 && flag3 && flag4) {
						cheeseMap[k][l] = 2;
					}
				}
			}
		}

	}
	static class Point{
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static String input = "11 15\r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0\r\n"
			+ "0 0 0 1 1 0 0 0 1 0 0 0 1 0 0\r\n"
			+ "0 0 1 0 1 1 1 1 0 1 1 1 0 1 0\r\n"
			+ "0 0 1 1 0 1 0 0 1 1 1 0 1 1 0\r\n"
			+ "0 0 1 0 1 0 1 1 1 1 1 1 0 1 0\r\n"
			+ "0 0 1 0 0 0 1 1 0 0 1 0 1 0 0\r\n"
			+ "0 1 1 0 1 0 0 0 0 1 1 1 0 0 0\r\n"
			+ "0 1 1 0 1 1 1 0 1 1 1 1 1 1 0\r\n"
			+ "0 0 0 1 1 0 1 0 1 0 0 0 0 1 0\r\n"
			+ "0 0 0 0 0 1 0 1 0 1 0 0 0 1 0\r\n"
			+ "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0";
}