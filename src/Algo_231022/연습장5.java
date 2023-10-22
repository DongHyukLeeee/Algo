package Algo_231022;

import java.util.*;

import java.io.*;

	
public class 연습장5 {
	
	static int V,E;
	static ArrayList<Integer>[] adjList;
	
	static class point{
		int x,cnt;

		public point(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
		
		
	}
	public static void main(String[] args) {
	
		Scanner sc  =new Scanner(input1);
		V=sc.nextInt();
		E=sc.nextInt();
		adjList = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adjList[i]=new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			int a =sc.nextInt()-1;
			int b =sc.nextInt()-1;
			adjList[a].add(b);
			adjList[b].add(a);
		}
		int res=Integer.MAX_VALUE;
		int whoHasMinimum = -999;
		for(int i=0; i<V; i++) {
			int temp = 0;
			for(int j=0; j<V; j++) {
				if(i!=j) {
					temp += bfs(i, j);
				}
			}
			if(temp<res) {
				res=temp;
				whoHasMinimum=i;
			}
		}
		System.out.println(whoHasMinimum+1);
	}
	
	static int bfs(int a, int finish) {
		Queue<point> q = new LinkedList<>();
		boolean visited[] = new boolean[V];
		q.add(new point(a, 0));
		visited[a]=true;
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			int curx = cur.x;
			int curcnt = cur.cnt;
			
			if(curx==finish) {
				return curcnt;
			}
			for(int x: adjList[curx]) {
				if(!visited[x]) {
					q.add(new point(x, curcnt+1));
					visited[x]=true;
				}
			}
		}
		
		return 999;
		
		
	}

	


	
	static String input1 = "5 5\r\n"
			+ "1 3\r\n"
			+ "1 4\r\n"
			+ "4 5\r\n"
			+ "4 3\r\n"
			+ "3 2";
	
}

