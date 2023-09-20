package Algo_230919;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_7733_치즈_도둑 {
	static int N;
	static boolean visited[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int arr[][];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Tcase = sc.nextInt();
		
		
		for(int tc= 1 ; tc<= Tcase; tc++) {
		N = sc.nextInt();
		
		arr = new int [N][N];
		
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int res = Integer.MIN_VALUE;
		for(int k=0; k<100; k++) {
			visited = new boolean[N][N];

			int sum = 0;
			for(int i=0; i<N;i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j]&&arr[i][j]>0) {
					bfs(i,j);
					sum++;}
				}
			}
			res = Math.max(res, sum);
			minusOne(arr);
		}
		System.out.println("#" + tc + " " + res);
		}
	}
	public static void bfs(int xstart, int ystart ) {
		Queue<Pointer> q = new LinkedList<>();
		q.offer(new Pointer(xstart,ystart));
		visited[xstart][ystart]=true;
		
		while(!q.isEmpty()) {
			Pointer current = q.poll();
			int x = current.x;
			int y = current.y;
			for(int i=0; i<4; i++) {
				int ni = x+di[i];
				int nj = y+dj[i];
				if(isInArr(ni, nj)&& arr[ni][nj]>0 &&!visited[ni][nj]) {
					q.offer(new Pointer(ni,nj));
					visited[ni][nj]=true;
				}
			}
		}


	}//bfs
	
	static class Pointer {
		int x, y;
		
		Pointer(int x,int y){
			this.x = x;
			this.y = y;
		}	
	}//Pointer
	
	public static boolean isInArr(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N ;
	}//isInArr
	

	public static void minusOne(int arr[][]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]--;
			}
		}
	}//minusOne
}
