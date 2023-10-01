package Algo_230929;

import java.util.*;
import java.io.*;

public class BJ_11779_최소비용_구하기_2{
	static int[] dist;
	static int[] prev;
	static int V,E;
	static int cnt= 0;
	static final int INF = Integer.MAX_VALUE;
	static class node{
		int y, w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}
		
	}
	
	static ArrayList<node>[] adjlist;
	static ArrayList<Integer> anslist;
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(input);
	
	V=sc.nextInt();
	E=sc.nextInt();
	adjlist = new ArrayList[V];
	for(int i=0; i<V; i++) {
		adjlist[i]= new ArrayList<>();
	}
	anslist = new ArrayList<>();
	for(int i=0; i<E; i++) {
		adjlist[sc.nextInt()-1].add(new node(sc.nextInt()-1, sc.nextInt()));
	}
	dist = new int[V];
	prev = new int[V];
	Arrays.fill(dist, INF);
	Arrays.fill(prev, -1);
	int start = sc.nextInt()-1;
	int finish = sc.nextInt()-1;
	
	dijkstra(start);
	 ArrayList<Integer> path = new ArrayList<>();
     int cur = finish;
     while (cur != -1) {
         path.add(cur);
         cur = prev[cur];
     }
     Collections.reverse(path);

     System.out.println(dist[finish]);
     System.out.println(path.size());
     for (int i = 0; i < path.size(); i++) {
         System.out.print((path.get(i) + 1));
         if (i < path.size() - 1) {
             System.out.print(" ");
         }
     }
 }
	static void dijkstra(int start) {
		dist[start]=0;
		PriorityQueue<node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w, b.w));
		pq.add(new node(start, 0));
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			int cury = cur.y;
			int curw = cur.w;
			
			if(curw>dist[cury]) continue;
			
			for(node a: adjlist[cury]) {
				int nexty = a.y;
				int nextw = curw+ a.w;
				if(nextw<dist[nexty]) {
					dist[nexty]=nextw;
					prev[nexty]=cury;
					pq.add(new node(nexty, nextw));
				}
				
			}
			
		}
	}
	static String input = "5\r\n"
			+ "8\r\n"
			+ "1 2 2\r\n"
			+ "1 3 3\r\n"
			+ "1 4 1\r\n"
			+ "1 5 10\r\n"
			+ "2 4 2\r\n"
			+ "3 4 1\r\n"
			+ "3 5 1\r\n"
			+ "4 5 3\r\n"
			+ "1 5";
}