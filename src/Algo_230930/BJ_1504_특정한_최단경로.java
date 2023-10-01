package Algo_230930;

import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.io.*;
import java.time.Year;

public class BJ_1504_특정한_최단경로 {
	
	static int v, e;
	static ArrayList<node>[] adjlist;
	static int [] dist;
	static class node{
		int y, w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(inputString2);
		
		v  = sc.nextInt();
		e  = sc.nextInt();
		adjlist = new ArrayList[v];
		for(int i=0; i<v ;i++) {
			adjlist[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++ ) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			adjlist[a].add(new node(b, c));
			adjlist[b].add(new node(a, c));
		}
		dist = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int stopover1 = sc.nextInt()-1;
		
		int stopover2 = sc.nextInt()-1;
		int res1= 0;
		int res2= 0;
		
		dijkstra(0);
		res1+=dist[stopover1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(stopover1);
		res1+=dist[stopover2];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(stopover2);
		res1+=dist[v-1];	
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(0);
		res2+=dist[stopover2];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(stopover2);
		res2+=dist[stopover1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(stopover1);
		res2+=dist[v-1];

		int finalres = Math.min(res1, res2);

		if (Math.abs(finalres) >= Integer.MAX_VALUE-100000) {
		    finalres = -1;
		}
		
		System.out.println(finalres);
		

	}
	
	
	static void dijkstra(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w, b.w));
		pq.add(new node(start, 0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			int cury = cur.y;
			int curw = cur.w;
			
			if(dist[cur.y]<cur.w) continue;
			
			for(node next : adjlist[cur.y]) {
				int nexty = next.y;
				int nextw = curw +next.w;
				if(dist[nexty]>nextw) {
					dist[nexty]=nextw;
					pq.add(new node(nexty, nextw));
				}
				
				
			}
			
		}
		
		
	}
	static String inputString =" 4 6\r\n"
			+ "1 2 3\r\n"
			+ "2 3 3\r\n"
			+ "3 4 1\r\n"
			+ "1 3 5\r\n"
			+ "2 4 5\r\n"
			+ "1 4 4\r\n"
			+ "2 3";
	
	static String inputString2 = "\r\n"
			+ "4 2\r\n"
			+ "1 3 5\r\n"
			+ "2 4 5\r\n"
			+ "3 2";
}