package Algo_230927;

import java.util.*;
import java.io.*;

public class BJ_스타트링크{
	static int F, S, G, U, D;
	static String resString = "use the stairs";
	static int resInt = Integer.MAX_VALUE;
	static class point {
		int stair, count;

		public point(int stair, int count) {
			this.stair = stair;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		boolean visited[] = new boolean [1000001];
		
		Queue<point> q = new LinkedList<>();
		visited[S]=true;
		q.add(new point(S,0));
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			int curStair =cur.stair;
			int curCount =cur.count;
			if(curStair==G) {resInt=curCount; break;}
			
            if (curStair + U <= F && !visited[curStair + U]) {
                q.add(new point(curStair + U, curCount + 1));
                visited[curStair + U] = true;
            }
            if (curStair - D >= 0 && !visited[curStair - D]) {  // changed 'curStair-D >= 0' to 'curStair-D >= 1' 
                q.add(new point(curStair - D, curCount + 1));
                visited[curStair - D] = true;
            }

			
			
			
		}
		if(resInt==Integer.MAX_VALUE) {
			System.out.println(resString);
		}
		else {
			System.out.println(resInt);

		}


	}

	static String input = "100 51 50 0 1\r\n" + 
			"";
}