package Algo_230924;

import java.awt.event.AdjustmentListener;
import java.nio.file.ClosedDirectoryStreamException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_1916_최소비용구하기 {
	static int V,E;
	static final int INF =Integer.MAX_VALUE;
	static int[] dist;
	static ArrayList<Node>[] adjList;
	
	
	static class Node{
		int v,w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		E = sc.nextInt();
		adjList = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adjList[i] = new ArrayList<>();
		}
		dist = new int[V];
		Arrays.fill(dist,INF);
		
		for(int i=0; i<E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			adjList[a-1].add(new Node(b-1,c));
		}
		
		int from = sc.nextInt();
		int to = sc.nextInt();
		
		dijkstra(from-1);
		System.out.println(dist[to-1]);
//		System.out.println(Arrays.toString(dist));
//		for (int i = 0; i < V; i++) {
//			System.out.print("정점 " + i + "에 인접한 정점들: ");
//			for (Node node : adjList[i]) {
//				System.out.print("(" + node.v + ", " + node.w + ") "); // 각 노드의 정점 번호와 가중치 출력
//			}
//			System.out.println(); // 줄 바꿈
//		}
//		System.out.println(Arrays.toString(dist));
//
//		
		
		
	}
	
	static void dijkstra(int start) {
		boolean[] visit = new boolean[V];
		dist[start]=0;
		
		for(int i=0; i<V-1;i++) {
			
			int min = INF;
			int idx = -1;
			
			for(int j=0; j<V ;j++) {
				if(!visit[j] && dist[j]<min) {
					min=dist[j];
					idx = j;
				}
			}
			
			if(idx==-1) break;
			visit[idx]=true;
			
			for(int j=0; j<adjList[idx].size(); j++) {
				Node cur = adjList[idx].get(j);
				
				if(!visit[cur.v]&&dist[cur.v]>dist[idx]+cur.w) {
					dist[cur.v]=dist[idx]+cur.w;
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
			+ "1 5" + "";

}
