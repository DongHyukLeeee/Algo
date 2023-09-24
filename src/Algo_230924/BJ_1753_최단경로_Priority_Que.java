package Algo_230924;

import java.util.*;

import java.io.*;

public class BJ_1753_최단경로_Priority_Que {

	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] adjList;
	static int dist[];
	static int V, E, Start;

	static class Node {
		int y, w;

		public Node(int y, int w) {

			this.y = y;
			this.w = w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();
		Start = sc.nextInt();
		dist = new int[V];
		Arrays.fill(dist, INF);
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int fi = sc.nextInt();
			int w = sc.nextInt();
			
			adjList[st-1].add(new Node(fi-1,w));
		}
		dijkstra();
		for(int a : dist) {
			System.out.println(a==INF ? "INF" : a );
		}
		for (int i = 0; i < V; i++) {
			System.out.print("정점 " + i + "에 인접한 정점들: ");
			for (Node node : adjList[i]) {
				System.out.print("(" + node.y + ", " + node.w + ") "); // 각 노드의 정점 번호와 가중치 출력
			}
			System.out.println(); // 줄 바꿈
		}

	}
	
	static void dijkstra() {
		dist[Start-1]=0; 
		boolean visit[] = new boolean[V];
		
		for(int i=0; i<V-1; i++) { 
			int min = INF;
			int idx = -1;
			
			for(int j=0; j<V-1;j++) {
				if(dist[j]<min&&!visit[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx==-1) break;
			visit[idx]=true;
			
			for(int j=0; j<adjList[idx].size(); j++) {
				Node cur = adjList[idx].get(j);
				if(!visit[cur.y]&&dist[cur.y]>dist[idx]+cur.w) {
					dist[cur.y]=dist[idx]+cur.w;
				}
			}
			
		}
	}
	static String input = "5 6\r\n" + "1\r\n" + "5 1 1\r\n" + "1 2 2\r\n" + "1 3 3\r\n" + "2 3 4\r\n" + "2 4 5\r\n"
			+ "3 4 6";
}