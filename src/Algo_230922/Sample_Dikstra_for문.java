package Algo_230922;

import java.util.*;

public class Sample_Dikstra_for문 {
    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void dijkstra(ArrayList<ArrayList<Node>> graph, int start) {
        int numNodes = graph.size(); // 그래프의 노드 개수 가져오기
        int[] distance = new int[numNodes]; // 시작 노드로부터의 거리 배열 초기화
        boolean[] visited = new boolean[numNodes]; // 노드 방문 여부를 저장하는 배열 초기화

        Arrays.fill(distance, Integer.MAX_VALUE); // 모든 노드의 거리를 무한대로 설정
        distance[start] = 0; // 시작 노드의 거리는 0으로 설정

        for (int i = 0; i < numNodes - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minNode = -1;

            // 아직 방문하지 않은 노드 중에서 최소 거리를 가진 노드 찾기
            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minNode = j;
                }
            }

            if (minNode == -1) {
                break; // 모든 노드를 방문했거나 도달할 수 없는 노드가 있는 경우 종료
            }

            visited[minNode] = true; // 최소 거리를 가진 노드를 방문 처리

            // 최소 거리를 가진 노드를 통해 인접한 노드들의 최단 거리 업데이트
            for (Node neighbor : graph.get(minNode)) {
                int newDistance = distance[minNode] + neighbor.weight; // 새로운 거리 계산
                if (newDistance < distance[neighbor.vertex]) {
                    distance[neighbor.vertex] = newDistance; // 최단 거리 업데이트
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

        ArrayList<ArrayList<Node>> graph = new ArrayList<>(numNodes);

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
            + "1";
}
