package Algo_230929;

import java.util.*;

import javax.print.attribute.IntegerSyntax;

import java.io.*;

public class BJ_1238_파티 {
	static int v,e,destination;
	static int dist [] ;
	static ArrayList<node>[] adjLists;
	
	static class node{
		int y, w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		v=sc.nextInt();
		e=sc.nextInt();
		destination=sc.nextInt()-1;
		adjLists = new ArrayList[v];
		for(int i=0; i<v; i++) {
			adjLists[i] = new ArrayList<>();
		}
		dist = new int [v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<e; i++) {
			adjLists[sc.nextInt()-1].add(new node(sc.nextInt()-1, sc.nextInt()));
		}
		int maxi  = Integer.MIN_VALUE;
		for(int i=0; i<v; i++) {
			int sum = 0;
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(i);
			sum+=dist[destination];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(destination);
			sum+=dist[i];
			maxi = Math.max(maxi, sum);
		}
		System.out.println(maxi);

	}
	
	static void dijkstra(int start) {
		PriorityQueue<node> pq  = new PriorityQueue<>((a,b)->(Integer.compare(a.w, b.w)));
		dist[start] = 0;
		pq.add(new node(start, 0));
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			int cury = cur.y;
			int curw = cur.w;

			if(curw>dist[cury]) {continue;}
			
			for(node next : adjLists[cury]) {
				int nexty = next.y;
				int nextw = curw + next.w;
				if(dist[nexty]>nextw) {
					dist[nexty]=nextw;
					pq.add(new node(nexty, nextw));
				}
				
			}
			
			
		}
		
	}
	
	static String input = "4 8 2\r\n"
			+ "1 2 4\r\n"
			+ "1 3 2\r\n"
			+ "1 4 7\r\n"
			+ "2 1 1\r\n"
			+ "2 3 5\r\n"
			+ "3 1 2\r\n"
			+ "3 4 4\r\n"
			+ "4 2 3";
}