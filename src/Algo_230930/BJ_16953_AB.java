package Algo_230930;
import java.util.*;
import java.io.*;

public class BJ_16953_AB {
	static long N,M;
	
	static class point {
		long x;
		int cnt;

		public point(long x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextLong();
		M=sc.nextLong();
		
			
		System.out.println(bfs());
	}
	static int bfs() {
		Queue <point> queue = new LinkedList<>();
		
		queue.add(new point(N, 1));
		while(!queue.isEmpty()) {
			point cur = queue.poll();
			long curx = cur.x;
			int curcnt = cur.cnt;
			if(curx==M) {
				return curcnt;
			}
			
			if(curx*2<=M) {
				queue.add(new point(2*curx, curcnt+1));
			}
			if(curx*10+1<=M) {
				queue.add(new point(curx*10+1, curcnt+1));
		
			}
			
			
			
		}
		
		return -1;
	}
	
}