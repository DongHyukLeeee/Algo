package Algo_230929;

import java.util.*;

import java.io.*;

public class BJ_1719_택배 {
	static int[] dist;
	static int[] where;
	static final int INF = Integer.MAX_VALUE;

	static class node {
		int y, w;??

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}

	}

	static ArrayList<node>[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt();
		int E = sc.nextInt();
		dist = new int[V];
		where = new int[V];
		adjList = new ArrayList[V];
		Arrays.fill(dist, INF);
		Arrays.fill(where, -1);
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			int w = sc.nextInt();

			adjList[u].add(new node(v, w));
			adjList[v].add(new node(u, w)); // Add the reverse edge
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int k = 0; k < V; k++) {

//			?dist = new int[V]; // Initialize dist array for each vertex k
			where = new int[V]; // Initialize where array for each vertex k
			Arrays.fill(dist, INF);
			Arrays.fill(where, -1);
			dijkstra(k);

			for (int i = 0; i < V; i++) {
				if (i == k) {
					System.out.printf("- ");

				} else {
					int cur = i;
					int firstDestination = -1; // Initialize with -1
					while (cur != k) {

						firstDestination = cur; // Update firstDestination
						cur = where[cur];
					}

					System.out.printf("%d ", firstDestination + 1);
				}
			}

			System.out.println();
		}

	}

	static void dijkstra(int start) {
		dist[start] = 0;
		PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
		pq.add(new node(start, 0));

		while (!pq.isEmpty()) {
			node cur = pq.poll();
			int cury = cur.y;
			int curw = cur.w;

			if (curw > dist[cury])
				continue;

			for (node a : adjList[cury]) {
				int nexty = a.y;
				int nextw = curw + a.w;

				if (nextw < dist[nexty]) {
					where[nexty] = cury;
					dist[nexty] = nextw;
					pq.add(new node(nexty, nextw));
				}
			}
		}

	}

	static String input = "6 10\r\n" + "1 2 2\r\n" + "1 3 1\r\n" + "2 4 5\r\n" + "2 5 3\r\n" + "2 6 7\r\n" + "3 4 4\r\n"
			+ "3 5 6\r\n" + "3 6 7\r\n" + "4 6 4\r\n" + "5 6 2";
}