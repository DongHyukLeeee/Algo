package Algo_230919;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_1226_미로1 {
	static int M, N;
	static boolean visited[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int arr[][];

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		arr = new int [16][16];
		visited = new boolean[16][16];

		for(int tc=1; tc<=10; tc++) {
			
		sc.nextInt();
		String temp[] = new String[16];
		for(int i=0; i<16; i++) {
			temp[i] = sc.next();
		}
		
		
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				arr[i][j]= temp[i].charAt(j)-'0';
				visited[i][j] = false;
			}
		}
		
		int i_2 = -1;
		int j_2 = -1;
		aa: for(i_2=0; i_2<16; i_2++) {
			for(j_2=0; j_2<16; j_2++) {
				if(arr[i_2][j_2]==2) {
					break aa;
				}
			}
		}

		
		System.out.println("#" + tc + " " + bfs(i_2,j_2));

		}//tcase
	}
	
	public static int bfs(int StartI, int StartJ) {
		
		Queue<Pointer> q = new LinkedList<>();
		q.offer(new Pointer(StartI,StartJ,1));	
		visited[StartI][StartJ] = true;
		
		while(!q.isEmpty()) {
			Pointer current = q.poll();
			int x = current.x;
			int y = current.y;
			int count = current.count;
			if(arr[x][y]==3) {
				return 1;
			}
			for(int i=0; i<4 ;i++) {
				int ni = x+di[i];
				int nj = y+dj[i];
						
					if(isInArr(ni, nj) && arr[ni][nj]!=1 &&!visited[ni][nj] ) {
					q.offer(new Pointer(ni,nj,count+1));
					visited[ni][nj]=true;
					}
				}

			}//for
			
		
		
		return 0;
	}
	
	static class Pointer {
		int x, y, count;
		
		Pointer(int x,int y,int count){
			this.x = x;
			this.y = y;
			this.count = count;
		}	
	}
	
	public static boolean isInArr(int x, int y) {
		return x>=0 && y>=0 && x<16 && y<16 ;
	}
		
}
