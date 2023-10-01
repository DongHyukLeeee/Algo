package Algo_230929;

import java.util.*;

import javax.swing.JMenu;

import java.io.*;

public class BJ_서강그라운드 {
	
	static int dist [] ;
	static ArrayList<node>[] adjlist ;
	static int V;
	static final int INF = Integer.MAX_VALUE;
	
	static class node{
		int y, w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		V =sc.nextInt();
		int maxi = sc.nextInt();
		int E = sc.nextInt();
		int items[] = new int[V];
		for(int i=0; i<V ;i++) {
			items[i]=sc.nextInt();
		}
		adjlist = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adjlist[i]= new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist, INF);
		for(int i=0; i<E ;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			int c = sc.nextInt();
			adjlist[a].add(new node(b, c));
			adjlist[b].add(new node(a, c));
		}
		
		
		int maxisum = Integer.MIN_VALUE; 
		for(int i=0; i<V; i++) {
			Arrays.fill(dist, INF);
			dijkstra(i);
		int sum = 0;
		for(int j=0; j<V; j++ ) {
			if(dist[j]<=maxi) {
				sum+=items[j];
			}
		}
		maxisum = Math.max(sum, maxisum);
		}
		
		System.out.println(maxisum);

	}
	
	static void dijkstra(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w, b.w));
		pq.add(new node(start,0));
		dist[start]=0;
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			int cury = cur.y;
			int curw = cur.w;
			
			if(dist[cury]<curw) continue;
			for(node next: adjlist[cury]) {
				int nexty = next.y;
				int nextw = curw + next.w;
				if(dist[nexty]>nextw) {
					dist[nexty]=nextw;
					pq.add(new node(nexty, nextw));
				}
			}
			
			
			
		}
		
	}
	static String input = "5 5 4\r\n"
			+ "5 7 8 2 3\r\n"
			+ "1 4 5\r\n"
			+ "5 2 4\r\n"
			+ "3 2 3\r\n"
			+ "1 2 3";
}