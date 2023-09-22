package Algo_230922;

import java.util.*;

public class SW_1249 {
	
	static class Pointer{
		int point_i, point_j, sum;
		
		Pointer(int point_i, int point_j, int sum) {
		this.point_i = point_i;
		this.point_j = point_j;
		this.sum = sum;
		}
	}
	
	static boolean isInArr(int x, int y) {
		return x>=0&&y>=0&&x<N&&y<N;
	}
	
	static int map [][] ;
	static int di []= {-1,1,0,0};
	static int dj []= {0,0,1,-1};
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		N =sc.nextInt();
		map= new int [N][N];
		for(int i=0; i<N ;i++) {
			String temp = sc.next();
			for(int j=0; j<N; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}

		System.out.println("result is " + bfs());

	}//main
	
	public static int bfs() {
		boolean visited[][] = new boolean[N][N];
		Queue<Pointer> q = new LinkedList<>();
		q.offer(new Pointer(0,0,0));
		visited[0][0]=true;
		int mini = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Pointer current =q.poll();
			int curr_i = current.point_i;
			int curr_j = current.point_j;
			int curr_sum = current.sum;

			if(curr_i==N-1 &&curr_j==N-1) {
				mini = Math.min(mini, curr_sum);
				continue;
			}
			for(int i=0; i<4; i++) {
				int ni = curr_i + di[i];
				int nj = curr_j + dj[i];
				if(isInArr(ni, nj)&&!visited[ni][nj]) {
					q.add(new Pointer(ni,nj,curr_sum+map[curr_i][curr_j]));
					visited[ni][nj]=true;
				}
			}
		
			
			
		}
		return mini;
	}	
	
	static String input = "4\r\n" + 
			"0001\r\n" + 
			"0001\r\n" + 
			"0001\r\n" + 
			"1110";
}