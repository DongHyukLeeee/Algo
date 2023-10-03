package Algo_231002;

import java.util.*;

import javax.swing.event.ListDataEvent;

import java.io.*;

public class BJ_삼성SW기출_인구이동 {
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
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Mini = sc.nextInt();
		Maxi = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int k;
		for (k = 0 ; k<=2000; k++) {
		boolean check = false;
		boolean visited[][] = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N ; j++) {
				if(!visited[i][j]) {
					ArrayList<int [] > indList = new ArrayList<>();  
					bfs(i, j, indList, visited);
					if(indList.size()>=2) {
						check=true;
						}

					int sum=0;
					int cnt=0;
				for(int temp[] : indList) {
					sum+=map[temp[0]][temp[1]];
					cnt++;
				}
				for(int temp[] : indList) {
					map[temp[0]][temp[1]]=sum/cnt;
				}
			}
			}
		}
		if(!check) break;

		}

		
		System.out.println(k);
	
	
	}

	static void bfs(int x, int y, ArrayList<int[]> indlist, boolean [][] visited) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(x, y));
		visited[x][y]=true;
		int temp1 [] = new int[2]; 
		temp1[0]=x;
		temp1[1]=y;
		indlist.add(temp1);
		while (!q.isEmpty()) {
			point cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;

			for(int i=0; i<4; i++) {
				int nx = curx+di[i];
				int ny = cury+dj[i];
				if(nx<0||ny<0||nx>=N||ny>=N) continue;
				if(!visited[nx][ny]&&Math.abs(map[nx][ny]-map[curx][cury])>=Mini&&Math.abs(map[nx][ny]-map[curx][cury])<=Maxi) {
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

	static String input1 = "2 20 50\r\n" + "50 30\r\n" + "20 40";
	static String input2 = "2 40 50\r\n" + "50 30\r\n" + "20 40";
	static String input3 = "2 20 50\r\n" + "50 30\r\n" + "30 40";
}