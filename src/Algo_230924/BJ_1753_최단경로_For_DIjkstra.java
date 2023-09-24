package Algo_230924;

import java.util.*;
import java.io.*;

public class BJ_1753_최단경로_For_DIjkstra {

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
        Scanner sc = new Scanner(System.in);
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

            adjList[st - 1].add(new Node(fi - 1, w));
        }
        dijkstra();
        printResult();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        pq.offer(new Node(Start - 1, 0));
        dist[Start - 1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int here = cur.y;
            int cost = cur.w;

            if (dist[here] < cost)
                continue;

            for (Node next : adjList[here]) {
                int there = next.y;
                int nextCost = cost + next.w;

                if (dist[there] > nextCost) {
                    dist[there] = nextCost;
                    pq.offer(new Node(there, nextCost));
                }
            }
        }
    }

    static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
