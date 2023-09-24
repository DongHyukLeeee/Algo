package Algo_230921;


import java.util.*;

public class 다잌스트라_01_반복문 {
	static int[] dist;
	static int V, E;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] adjList;

	static class Node {
		int v, w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();
		dist = new int[V];
		Arrays.fill(dist, INF);

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			adjList[A].add(new Node(B, C));
		}

		dijkstra(0);
		System.out.println(Arrays.toString(dist));
		for (int i = 0; i < V; i++) {
			System.out.print("정점 " + i + "에 인접한 정점들: ");
			for (Node node : adjList[i]) {
				System.out.print("(" + node.v + ", " + node.w + ") "); // 각 노드의 정점 번호와 가중치 출력
			}
			System.out.println(); // 줄 바꿈
		}

	}

	static void dijkstra(int start) {

		dist[start] = 0;
		boolean visited[] = new boolean[V];

		for (int i = 0; i < V - 1; i++) {
			int min = INF;
			int idx = -1;

			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}

			if (idx == -1)
				break;
			visited[idx] = true;

			for (int j = 0; j < adjList[idx].size(); j++) {

				Node curr = adjList[idx].get(j);

				if (!visited[curr.v] && dist[curr.v] > dist[idx] + curr.w) {
					dist[curr.v] = dist[idx] + curr.w;
				}
			}
		}

	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";

}
