package Algo_231001;

import java.util.*;

import java.io.*;

public class BJ_11404_플로이드 {
	static int[] dist;
	static ArrayList<node>[] adjlist;
	static int v, e;

	static class node {
		int y, w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		v = sc.nextInt();
		e = sc.nextInt();
		dist = new int[v];
		adjlist = new ArrayList[v];
		for (int i = 0; i < v; i++) {
			adjlist[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();
			adjlist[a].add(new node(b, c));
		}
		
		for(int i=0; i<v; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(i);
			for(int a: dist) {
				if(a==Integer.MAX_VALUE) {
					System.out.printf("%d ", 0);
				}
				else {
					System.out.printf("%d ", a);

				}
			}
			System.out.println();
		}
		


	}

	static void dijkstra(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w, b.w));
		pq.add(new node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			node cur = pq.poll();
			int cury = cur.y;
			int curw = cur.w;
			
			if(curw>dist[cury]) continue;
			
			for(node next: adjlist[cury]) {
				int nexty = next.y;
				int nextw = curw+next.w;
				if(nextw<dist[nexty]) {
					dist[nexty] = nextw;
					pq.add(new node(nexty, nextw));
				}
				
				
			}
			
			
		}
		
		
	}
	static String input = "5\r\n" + "14\r\n" + "1 2 2\r\n" + "1 3 3\r\n" + "1 4 1\r\n" + "1 5 10\r\n" + "2 4 2\r\n"
			+ "3 4 1\r\n" + "3 5 1\r\n" + "4 5 3\r\n" + "3 5 10\r\n" + "3 1 8\r\n" + "1 4 2\r\n" + "5 1 7\r\n"
			+ "3 4 2\r\n" + "5 2 4";
}