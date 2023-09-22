package Algo_230922;

import java.util.*;

public class Sample_Priority_Queue {
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static void dijkstra(List<List<Node>> graph, int start) {
        int numNodes = graph.size();
        int[] distance = new int[numNodes];
        Arrays.fill(distance, Integer.MAX_VALUE); // 초기 거리를 무한대로 설정
        distance[start] = 0; // 시작 노드의 거리는 0으로 설정

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐 선언
        pq.offer(new Node(start, 0)); // 시작 노드를 큐에 추가

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll(); // 우선순위 큐에서 가장 가까운 노드를 가져옴
            int x = currentNode.vertex; // 현재 노드의 인덱스
            int y = currentNode.weight; // 현재 노드까지의 거리

            if (y > distance[x]) {
                continue; // 이미 처리한 노드이거나 더 긴 거리를 가진 경우, 처리하지 않고 건너뜀
            }

            for (Node neighbor : graph.get(x)) {
                int newDistance = y + neighbor.weight; // 현재 노드를 거쳐서 이웃 노드에 도달하는 새로운 거리 계산
                if (newDistance < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDistance; // 새로운 거리로 업데이트
                    pq.offer(new Node(neighbor.vertex, newDistance)); // 업데이트된 거리와 함께 이웃 노드를 우선순위 큐에 추가
                }
            }

        }

        // 최단 경로 출력
        for (int i = 0; i < numNodes; i++) {
            System.out.println("노드 " + i + "까지의 최단 거리: " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(input);
        
        // 노드 개수와 간선 개수 입력
        int numNodes = scanner.nextInt();
        int numEdges = scanner.nextInt();
        
        List<List<Node>> graph = new ArrayList<>(numNodes);

        for (int i = 0; i < numNodes; i++) {
            graph.add(new ArrayList<>()); // 인접 리스트 초기화
        }

        // 그래프 초기화 (노드와 가중치 추가)
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.get(source).add(new Node(target, weight));
        }
        
        int startNode = scanner.nextInt(); // 시작 노드 입력
        scanner.close();
        
        dijkstra(graph, startNode); // 시작 노드를 선택하여 다익스트라 알고리즘 실행
    }
    
    static String input = "6 11\r\n" +
            "0 1 4\r\n" +
            "0 2 2\r\n" +
            "0 5 25\r\n" +
            "1 3 8\r\n" +
            "1 4 7\r\n" +
            "2 1 1\r\n" +
            "2 4 4\r\n" +
            "3 0 3\r\n" +
            "3 5 6\r\n" +
            "4 3 5\r\n" +
            "4 5 12\r\n"
            + "0";
}
