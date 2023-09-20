package Algo_230920;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Edge {
    int src, dest, weight;

    // Edge 생성자
    public Edge(int src, int dest, int weight) {
        this.src = src;     // 간선의 출발 노드
        this.dest = dest;   // 간선의 도착 노드
        this.weight = weight; // 간선의 가중치
    }
}

//Edge 클래스:
//
//Edge 클래스는 간선을 나타내는 클래스입니다. src는 출발 노드, dest는 도착 노드, weight는 간선의 가중치를 나타냅니다.

class Graph {
    int V, E;
    List<Edge> edges;

    // Graph 생성자
    public Graph(int V, int E) {
        this.V = V;         // 그래프의 정점 개수
        this.E = E;         // 그래프의 간선 개수
        edges = new ArrayList<>(); // 간선들을 저장하는 리스트
    }
  //Graph 클래스:
    //
    //Graph 클래스는 그래프를 나타내는 클래스입니다. V는 그래프의 정점 개수, E는 그래프의 간선 개수를 나타냅니다.
    //addEdge 메서드는 간선을 그래프에 추가하는 메서드입니다.
    // 간선을 추가하는 메서드
    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    // Kruskal 알고리즘을 사용하여 최소 신장 트리를 찾는 메서드
    public List<Edge> kruskalMST() {
        List<Edge> result = new ArrayList<>(); // 최소 신장 트리를 저장하는 리스트
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight)); // 가중치로 정렬

        DisjointSet disjointSet = new DisjointSet(V); // Disjoint Set 생성

        for (Edge edge : edges) {
            int srcRoot = disjointSet.find(edge.src); // 출발 노드의 루트 찾기
            int destRoot = disjointSet.find(edge.dest); // 도착 노드의 루트 찾기

            if (srcRoot != destRoot) { // 루트가 다르면 사이클이 형성되지 않음
                result.add(edge); // 최소 신장 트리에 간선 추가
                disjointSet.union(srcRoot, destRoot); // 두 노드를 연결
            }
        }

        return result;
    }
}

class DisjointSet {
    int[] parent, rank;

    // DisjointSet 생성자
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기에는 모든 노드가 자신을 가리킴
            rank[i] = 0; // 랭크 초기화
        }
    }

    // 루트를 찾는 메서드
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // 경로 압축(Path Compression)을 통해 루트를 찾음
        }
        return parent[x];
    }

    // 두 노드를 합치는 메서드
    public void union(int x, int y) {
        int xRoot = find(x); // x의 루트를 찾음
        int yRoot = find(y); // y의 루트를 찾음

        if (xRoot == yRoot) return; // 이미 같은 집합에 속해있음

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot; // xRoot를 yRoot에 붙임
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot; // yRoot를 xRoot에 붙임
        } else {
            parent[yRoot] = xRoot; // 랭크가 같으면 한 쪽을 다른 쪽에 붙이고 랭크를 증가시킴
            rank[xRoot]++;
        }
    }
}

//DisjointSet 클래스:
//
//DisjointSet 클래스는 Disjoint Set(서로소 집합)을 구현한 클래스로, Kruskal 알고리즘에서 간선들의 연결 여부를 관리하기 위해 사용됩니다.

public class Sample_KruskalAlgorithm {
    public static void main(String[] args) {
        int V = 4; // 그래프의 정점 개수
        int E = 5; // 그래프의 간선 개수
        Graph graph = new Graph(V, E); // 그래프 생성

        // 간선 추가
        graph.addEdge(0, 1, 10); // 정점 0에서 1로 가는 가중치 10인 간선 추가
        graph.addEdge(0, 2, 6);  // 정점 0에서 2로 가는 가중치 6인 간선 추가
        graph.addEdge(0, 3, 5);  // 정점 0에서 3로 가는 가중치 5인 간선 추가
        graph.addEdge(1, 3, 15); // 정점 1에서 3로 가는 가중치 15인 간선 추가
        graph.addEdge(2, 3, 4);  // 정점 2에서 3로 가는 가중치 4인 간선 추가

        List<Edge> minimumSpanningTree = graph.kruskalMST(); // Kruskal 알고리즘으로 최소 신장 트리 계산

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight); // 최소 신장 트리 출력
        }
    }
}

//
//
//제공한 Java 코드는 Kruskal 알고리즘을 사용하여 그래프의 최소 신장 트리를 구현한 것입니다. 아래에서 코드의 주요 부분을 설명하겠습니다.
//


//kruskalMST 메서드는 Kruskal 알고리즘을 사용하여 최소 신장 트리를 계산하는 메서드입니다.

//find 메서드는 특정 노드의 루트(대표 원소)를 찾는 메서드로, 경로 압축(Path Compression)을 사용하여 최적화됩니다.
//union 메서드는 두 노드를 하나의 집합으로 합치는 메서드로, 두 집합을 연결하고 랭크(Rank)를 관리하여 효율적으로 집합을 유지합니다.
//Sample_KruskalAlgorithm 클래스:
//
//main 메서드에서는 실제로 Kruskal 알고리즘을 사용하여 최소 신장 트리를 계산합니다.
//그래프를 생성하고 간선을 추가한 후, kruskalMST 메서드를 호출하여 최소 신장 트리를 계산하고 결과를 출력합니다.
//Kruskal 알고리즘은 그래프의 모든 간선을 가중치 오름차순으로 정렬한 뒤, 사이클을 형성하지 않으면서 간선을 하나씩 추가하여 최소 신장 트리를 만드는 알고리즘입니다. Disjoint Set을 사용하여 간선들의 연결 여부를 확인하고, 이미 연결된 노드들을 합치는 작업을 수행합니다. 이를 통해 최소 신장 트리를 구성하게 됩니다.