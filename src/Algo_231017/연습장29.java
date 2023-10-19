package Algo_231017;

import java.util.*;

import java.io.*;

	
public class 연습장29 {
	
	static class point{
		
		public point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

		int x,cnt;
		
		
	}
	
	static int[] arr;
	static int N ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);

		N = sc.nextInt();
		
		arr  = new int [N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0));

		
		while(!q.isEmpty()){
			point cur = q.poll();
			int curcnt = cur.cnt;
			int curx = cur.x;

			if(curx>N-1) continue;
			
			int arrNum = arr[curx];
			

			if(curx==N-1) {
				return curcnt;
			}
			if (arrNum ==0)continue;
			for(int i=1; i<=arrNum; i++) {
				q.add(new point(curx+i,curcnt+1));

			}
			
		}
		
		return -1;
	}
	static String input1 = "10\r\n" + 
			"1 2 0 1 3 2 1 5 4 2";
}