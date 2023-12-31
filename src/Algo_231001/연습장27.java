package Algo_231001;

import java.util.*;

import javax.swing.event.ListDataEvent;

import java.io.*;

public class 연습장27 {
	static int N, Mini, Maxi;
	static int[][] map;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		N = sc.nextInt();
		Mini = sc.nextInt();
		Maxi = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; i < N; i++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; i < N ; i++) {
				ArrayList<int [] > indList = new ArrayList<>();  
				bfs(i, j, indList);
				int sum=0;
				int cnt=1;
				for(int temp[] : indList) {
					sum+=map[temp[0]][temp[1]];
					cnt++;
				}
				for(int temp[] : indList) {
					map[temp[0]][temp[1]]=sum/cnt;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0;  j < N; j++) {
				System.out.printf("%d ",map[i][j]);
				
			}
			System.out.println();
		}
		
	
	}

	static void bfs(int x, int y, ArrayList<int[]> indlist) {
		Queue<point> q = new LinkedList<>();
		boolean visited[] [] = new boolean[N][N];
		q.add(new point(x, y));
		visited[x][y]=true;
		
		while (!q.isEmpty()) {
			point cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;

			for(int i=0; i<4; i++) {
				int nx = curx+di[i];
				int ny = cury+dj[i];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(!visited[nx][ny]&&map[nx][ny]-map[curx][cury]>=Mini&&map[nx][ny]-map[curx][cury]<=Maxi) {
					int temp[] = new int [2];
					temp[0]=nx;
					temp[1]=ny;
					indlist.add(temp);
					q.add(new point(nx,ny));
					visited[nx][ny]=true;
				}
			}
		}
	}

//	static String input1 = "2 20 50\r\n" + "200 100\r\n" + "300 400";
	static String input1 = "2 20 50\r\n" + "50 30\r\n" + "20 40";
	static String input2 = "2 40 50\r\n" + "50 30\r\n" + "20 40";
	static String input3 = "2 20 50\r\n" + "50 30\r\n" + "30 40";
}