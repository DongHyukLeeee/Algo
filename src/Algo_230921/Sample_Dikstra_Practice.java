package Algo_230921;

import java.util.*;

public class Sample_Dikstra_Practice {

	static class Node implements Comparable<Node> {
		int weight, vertex;

		public Node(int weight, int vertex) {
			this.weight = weight;
			this.vertex = vertex;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}// NODE CLASS

	public static void dijkstra(ArrayList<ArrayList<Node>> graph, int start) {
	
		//numNodes, distances, distacnes init, arrayfill, distances start
		int numNodes = graph.size();
		int distance[] = new int [numNodes];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
	
		//Priority Que 시작, offer
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		//while문 시작, Node curr, 변수 받기, if 문 

		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int x = current.vertex; //x vertex (index)
			int y = current.weight; // y :; (weight) imagine y=f(x) function
			
			
			if(y>distance[x]) {
				continue; 
			}
			for(Node neighbor : graph.get(x)) {
				int newDistance = y + neighbor.weight;
				if(newDistance < distance[neighbor.vertex]) {
					distance[neighbor.vertex] = newDistance;
					pq.offer(new Node(neighbor.vertex,newDistance));
				}
			}
			
		}
		
		for(int i=0; i<numNodes; i++) {
			System.out.println("노드"+i + "까지의 최단 거리 : " + distance[i]);
		}
		
		
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(input);

		int numNodes = sc.nextInt();
		int numEdges = sc.nextInt();

		ArrayList<ArrayList<Node>> graph = new ArrayList<>(numNodes);

		for (int i = 0; i < numNodes; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < numEdges; i++) {
			int source = sc.nextInt();
			int target = sc.nextInt();
			int weight = sc.nextInt();
			graph.get(source).add(new Node(target, weight));
		}

		int startNode = sc.nextInt();
		sc.close();

		dijkstra(graph, startNode);
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "0";

}