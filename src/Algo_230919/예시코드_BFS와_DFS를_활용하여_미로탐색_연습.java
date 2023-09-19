package Algo_230919;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 예시코드_BFS와_DFS를_활용하여_미로탐색_연습 {
	static int M, N;
	static boolean visited[][];
	static int di[] = { -1, 1, 0, 0 };
	static int dj[] = { 0, 0, 1, -1 };
	static int [][] arr;

	public static void main(String[] args) {
		M = 6;
		N = 4;
		visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
		arr = new int [][] {
				{1,0,1,1,1,1},
				{1,0,1,0,1,0},
				{1,0,1,0,1,1},
				{1,1,1,0,1,1}
		};

		System.out.println(bfs(0,0));
		
	}	

	public static int bfs(int StartX, int StartY) {
		Queue<Pointer> q = new LinkedList<>();
		q.offer(new Pointer(StartX, StartY, 1));
		visited[StartX][StartY] = true;

		while (!q.isEmpty()) {
			Pointer current = q.poll();
			int x = current.x;
			int y = current.y;
			int count = current.count;
			
			if (x == M - 1 && y == N - 1)
				{
				return count;
				
				}
			
			for (int i = 0; i < 4; i++) {
				int nx = x + di[i];
				int ny = y + dj[i];
				if(isInArr(nx, ny) && arr[nx][ny]==1 && !visited[nx][ny]) {
					q.offer(new Pointer(nx,ny,count+1));
					visited[nx][ny]=true;
				}
			}

		}

		return -1;

	}

	public static boolean isInArr(int x, int y) {

		return x >= 0 && y >= 0 && x < M && y < N;
	}

	static class Pointer {
		int x, y, count;

		Pointer(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

}