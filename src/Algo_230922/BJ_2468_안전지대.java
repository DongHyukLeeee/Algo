package Algo_230922;

import java.lang.reflect.Array;
import java.util.*;


public class BJ_2468_안전지대 {
	static int N;
	static boolean[][] visit ;
	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 N =sc.nextInt();
		
		int map [][] = new int [N][N];
		
		for(int i=0; i<N ;i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int res = Integer.MIN_VALUE;
		for(int k=0; k<100;k++) {
			int cnt = 0;
			visit = new boolean [N][N];
			for(int i=0; i<N ;i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]&&map[i][j]>0) {
					checkwhereisnotzero(map,i,j);
					cnt++;
					}
				}
			}
			res = Math.max(res,cnt);
			minus(map);
		}
		
		
		System.out.println(res);

	
	}
	public static void checkwhereisnotzero(int arr[][], int startI, int startJ) {
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		visit[startI][startJ]=true;
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(startI,startJ));
		
		while(!q.isEmpty()){
			Point current = q.poll();
			int currentX =current.x;
			int currentY =current.y;
			for(int i=0; i<4; i++) {
				int nx = currentX+dx[i];
				int ny = currentY+dy[i];
				if(nx>=0&&ny>=0&&nx<N && ny<N &&!visit[nx][ny]&&arr[nx][ny]>0) {
					q.add(new Point(nx,ny));
					visit[nx][ny]=true;
				}
			}//for

		}//while
	}//method
	
	public static void minus(int arr[][]) {
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]--;
			}
		}
	}
	
	static String input = "7\r\n"
			+ "9 9 9 9 9 9 9\r\n"
			+ "9 2 1 2 1 2 9\r\n"
			+ "9 1 8 7 8 1 9\r\n"
			+ "9 2 7 9 7 2 9\r\n"
			+ "9 1 8 7 8 1 9\r\n"
			+ "9 2 1 2 1 2 9\r\n"
			+ "9 9 9 9 9 9 9";
}