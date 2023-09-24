package Algo_230924;
import java.util.*;

public class BJ_14567_선수과목 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> graph[] = new ArrayList[N];
        for (int i = 0; i <= N; i++) {
            graph[i]=new ArrayList<>();
        }

        int[] rank = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (rank[i] == 0) {
                dfs(graph, rank, i);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(rank[i]+1 + " ");
        }
    }

    static void dfs(List<List<Integer>> graph, int[] rank, int course) {
        for (int nextCourse : graph.get(course)) {
            if (rank[nextCourse] < rank[course] + 1) {
                rank[nextCourse] = rank[course] + 1;
                dfs(graph, rank, nextCourse);
            }
        }
    }



	static String input = "6 4\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2 5\r\n"
			+ "4 5";
}