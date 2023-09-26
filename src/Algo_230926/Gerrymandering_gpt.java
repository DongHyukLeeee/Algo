package Algo_230926;

package Algo_230926;

import java.util.*;

public class Gerrymandering_gpt {
    private static int V; // 노드의 수
    private static int[][] adjMatrix; // 무방향 그래프의 인접 행렬
    private static boolean[] visited;
    private static int[] population; // 각 노드의 인구 수
    private static int minDifference; // 두 지역구의 인구 수 차이의 최솟값

    public static void main(String[] args) {
        V = 6; // 노드의 수
        adjMatrix = new int[][]{
            {0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 1},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 0}
        };

        population = new int[]{20, 30, 10, 40, 50, 60};

        minDifference = Integer.MAX_VALUE;

        for (int i = 1; i <= V / 2; i++) {
            visited = new boolean[V];
            divideDistricts(0, i, new ArrayList<>());
        }

        System.out.println("최소 인구 차이: " + minDifference);
    }

    private static void divideDistricts(int node, int count, List<Integer> selectedNodes) {
        if (count == 0) {
            // 선택된 노드들로 지역구를 나누어봅니다.
            List<Integer> otherNodes = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (!selectedNodes.contains(i)) {
                    otherNodes.add(i);
                }
            }
            
            int populationA = 0;
            int populationB = 0;

            for (int i : selectedNodes) {
                populationA += population[i];
            }

            for (int i : otherNodes) {
                populationB += population[i];
            }

            int difference = Math.abs(populationA - populationB);
            minDifference = Math.min(minDifference, difference);
            
            // 선택된 지역구가 연결되어 있는지 확인합니다.
            if (isConnected(selectedNodes) && isConnected(otherNodes)) {
                // 선택된 지역구가 연결되어 있으면 결과 출력
                System.out.println("최소 인구 차이: " + minDifference);
            }
            
            return;
        }

        if (node >= V) {
            return;
        }

        // 현재 노드를 선택하는 경우
        selectedNodes.add(node);
        divideDistricts(node + 1, count - 1, selectedNodes);
        selectedNodes.remove(selectedNodes.size() - 1); // 백트래킹

        // 현재 노드를 선택하지 않는 경우
        divideDistricts(node + 1, count, selectedNodes);
    }

    // 노드들이 연결되어 있는지 확인하는 함수
    private static boolean isConnected(List<Integer> nodes) {
        Arrays.fill(visited, false);

        // 선택된 노드 중 하나를 시작으로 DFS를 수행하여 연결 여부 확인
        dfs(nodes.get(0));

        // 모든 선택된 노드들이 방문되었으면 연결되어 있는 것으로 판단
        for (int node : nodes) {
            if (!visited[node]) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < V; i++) {
            if (adjMatrix[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
