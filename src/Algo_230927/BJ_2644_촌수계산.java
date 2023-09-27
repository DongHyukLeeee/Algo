
package Algo_230927;

import java.util.*;
import java.io.*;

public class BJ_2644_촌수계산 {
	
	static int V,E,Target1,Target2;
	static ArrayList<Integer> adjList[];

	static class point{
		
		int x, count;

		public point(int x, int count) {
			this.x = x;
			this.count = count;
		}
		
	}
	public static void main(String[] args) {
		
		
		 Scanner sc = new Scanner(input2);
		 	
		 V = sc.nextInt();
		 Target1 = sc.nextInt()-1;
		 Target2 = sc.nextInt()-1;
		 E =sc.nextInt();
		 adjList = new ArrayList[V];
		 
		 for(int i=0;i<V; i++) {
			 adjList[i] = new ArrayList<>();
		 }
		 
		 for(int i=0; i<E ;i++ ) {
			 int a = sc.nextInt()-1;
			 int b = sc.nextInt()-1;
			 adjList[a].add(b);
			 adjList[b].add(a);
		 }
		int res = -1;
		 
		 Queue<point> q = new LinkedList<>();
		 boolean visited[] = new boolean[V];
		 visited[Target1] =true;
		 q.add(new point(Target1,0));
		 
		 while(!q.isEmpty()) {
			point cur = q.poll();
			int curx = cur.x;
			int curcount = cur.count;
			if(curx==Target2) res=curcount;
			for(int i=0; i<adjList[curx].size();i++) {
				int next = adjList[curx].get(i);
				if(!visited[next]) {
					q.add(new point(next,curcount+1));
					visited[next]=true;
				}
			}
		 }
		 
		 System.out.println(res);
		
		
		

	}
	
	static String input1 = "9\r\n" + 
			"7 3\r\n" + 
			"7\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 7\r\n" + 
			"2 8\r\n" + 
			"2 9\r\n" + 
			"4 5\r\n" + 
			"4 6";
	static String input2 = "9\r\n" + 
			"8 6\r\n" + 
			"7\r\n" + 
			"1 2\r\n" + 
			"1 3\r\n" + 
			"2 7\r\n" + 
			"2 8\r\n" + 
			"2 9\r\n" + 
			"4 5\r\n" + 
			"4 6";
}