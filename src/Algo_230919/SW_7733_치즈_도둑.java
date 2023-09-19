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
		arr = new int [][] {
		            {1, 0, 1, 0, 0},
		            {1, 0, 1, 0, 1},
		            {0, 0, 0, 1, 1},
		            {0, 0, 0, 0, 0},
		            {1, 0, 0, 0, 1}
		        };
		N=5;        
		visited = new boolean[N][N];
		int sum = 0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				sum+=bfs(i,j);
			}
		}    
		System.out.println(sum);
	}
	public static int bfs(int xstart, int ystart ) {
		boolean flag = false;
		Queue<Pointer> q = new LinkedList<>();
		q.offer(new Pointer(xstart,ystart));
		visited[xstart][ystart]=true;
		
		while(!q.isEmpty()) {
			Pointer current = q.poll();
			int x = current.x;
			int y= current.y;
			for(int i=0; i<4; i++) {
				int ni = x+di[i];
				int nj = y+dj[i];
				if(isInArr(ni, nj)&& arr[ni][nj]!=0 &&!visited[ni][nj]) {
					q.offer(new Pointer(ni,nj));
					visited[ni][nj]=true;
					flag = true;
				} 
				
			}
			
		}
		if(flag) {
			return 1;
		}
		return 0;
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
	}
	public static void minus(int arr[], int minus) {
		

		
	}
}
