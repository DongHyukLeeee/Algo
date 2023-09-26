package Algo_230926;

import java.util.*;
import java.io.*;

public class BJ_10026_적록색약 {
	static int map [][] ;
	static boolean visited[][] ; 
	static int di[] = {1,-1,0,0};
	static int dj[] = {0,0,1,-1};
	static int N;
	static class point{
		int x,y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		
		String input = "5\r\n" + 
				"RRRBB\r\n" + 
				"GGBBB\r\n" + 
				"BBBRR\r\n" + 
				"BBRRR\r\n" + 
				"RRRRR";
		
		Scanner sc= new Scanner(input);
		 N = sc.nextInt();
		visited = new boolean [N][N];
		map = new int[N][N];
		for(int i=0; i<N ;i++) {
			String temp = sc.next();
			for(int j=0; j<N ;j++) {
				map[i][j]= temp.charAt(j)-'0';
			}
		}
		int cntNormal = 0;
		visited = new boolean [N][N];
		for(int i=0; i<N ;i++) {
			for(int j=0; j<N ;j++) {
				if(!visited[i][j])
				{bfs(i,j);
				cntNormal++;}
			}
		}
		visited = new boolean [N][N];
		
		for(int i=0; i<N ;i++) {
			for(int j=0; j<N ;j++) {
				if(map[i][j]=='R'-'0'){
					map[i][j]='G'-'0';
				}
			}
		}
		int cnt2 = 0;

		for(int i=0; i<N ;i++) {
			for(int j=0; j<N ;j++) {
				if(!visited[i][j])
				{bfs(i,j);
				cnt2++;}
			}
		}
		

		System.out.println(cntNormal);
		System.out.println(cnt2);

		}
	
		//input처리. char은 재수가 없으므로 int로 받자.
		
	static void bfs(int i_s, int j_s) {
			visited[i_s][j_s]= true;
			Queue <point> q = new LinkedList<>();
			q.add(new point(i_s,j_s));
			
			while(!q.isEmpty()) {
				point cur = q.poll();
				int curx = cur.x;
				int cury = cur.y;
				
				for(int i=0; i<4; i++) {
					int nx = curx+di[i];
					int ny = cury+dj[i];
					if(nx<0||ny<0||nx>=N||ny>=N) continue;
					if(!visited[nx][ny]&&map[curx][cury]==map[nx][ny]) {
						visited[nx][ny]=true;
						q.add(new point(nx,ny));
					}
				}
				
				
				
			}
			
			
	}
		
		
		

	
	
	
	
}