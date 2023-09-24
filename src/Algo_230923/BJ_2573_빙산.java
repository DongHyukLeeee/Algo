package Algo_230923;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BJ_2573_빙산 {
	static int M, N;
	static int[][] iceMap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visitice ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		

		M = sc.nextInt();
		N = sc.nextInt();

		iceMap = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				iceMap[i][j]=sc.nextInt();
			}
		}
		int year;
		for(year=0; year<=100; year++) {
		int cnt = 0;
		visitice = new boolean[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(iceMap[i][j]>0&&!visitice[i][j]) {
						bfs(i,j);
						cnt++;
					}
				} 
			}
			if(cnt>=2) {
				break;
			}
			else if(cnt==0) {
				year=0;
				break;
			}
			else {
				after1year();
			}

			
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%d ",iceMap[i][j]);
			}
			System.out.println();
		}
		System.out.println(year);


	}
	
	static void after1year() {
		boolean visit [][] = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(iceMap[i][j]>0) {
					visit[i][j]=true;

					int cnt = 0;
					for(int k=0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0&&ny>=0&&nx<M&&ny<N&&iceMap[nx][ny]==0&&!visit[nx][ny]) {
							cnt++;
						}
					}
					iceMap[i][j]-=cnt;
					if(iceMap[i][j]<0) {
						iceMap[i][j]=0;
					}
				}
			}
		}
	}
	
	static void bfs(int startx, int starty) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(startx,starty));
		visitice[startx][starty]=true;
		
		while(!q.isEmpty()) {
			Point curr = q.poll();
			int currx = curr.x;
			int curry = curr.y;
			
			for(int i=0; i<4; i++) {
				int nx = currx+dx[i];
				int ny = curry+dy[i];
				if(nx>=0&&ny>=0&&nx<M&&ny<N&&!visitice[nx][ny]&&iceMap[nx][ny]>0) {
					q.add(new Point(nx,ny));
					visitice[nx][ny]=true;
				}
			}
		}
		
	}
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static String input = "7 9\r\n"
			+ "\r\n"
			+ "0 0 0 0 0 0 0 0 0\r\n"
			+ "\r\n"
			+ "0 9 5 5 5 5 5 9 0\r\n"
			+ "\r\n"
			+ "0 5 9 5 5 5 9 5 0\r\n"
			+ "\r\n"
			+ "0 5 5 9 1 9 5 5 0\r\n"
			+ "\r\n"
			+ "0 5 9 5 5 5 9 5 0\r\n"
			+ "\r\n"
			+ "0 9 5 5 5 5 5 9 0\r\n"
			+ "\r\n"
			+ "0 0 0 0 0 0 0 0 0"
			;
}