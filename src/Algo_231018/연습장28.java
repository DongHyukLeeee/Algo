package Algo_231018;

import java.util.*;
import java.io.*;

public class BJ_11060_점프점프 {

	static int N;
	static int arr[];
	
	static class point{
		
		int x,y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);

		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();

		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<point> q = new LinkedList<>();
		
		q.add(new point(0, 0));
		boolean visited[] = new boolean[N];
		visited[0]=true;
		while(!q.isEmpty()) {
			point cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			
			if(curx>N-1) continue;
			int currentVal = arr[curx];
			
			if(curx==N-1) {
				return cury;
			}
			if (currentVal==0) continue;
			for(int i=1; i+curx<=N-1&&i<=currentVal; i++) {
				if(!visited[curx+i]) {
				q.add(new point(curx+i, cury+1));
				visited[curx+i]=true;
				}
			}
			
			
			
		}
		return -1;
			
		
	}

	static String input1 = "10\r\n" + "1 2 0 1 3 2 1 5 4 2";
}