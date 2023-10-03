package Algo_231003;

import java.util.*;
import java.io.*;

public class BJ_24526_전화돌리기 {
	static int N, E;
	static ArrayList<Integer>[] adjlist;
	static int[] degree;
	static int cnt = 0;

	static class node {
		int y, w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		N = sc.nextInt();
		E = sc.nextInt();
		degree = new int[N];
		adjlist = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjlist[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			adjlist[a].add(b);
			degree[b]++;
		}

		for (int i = 1; i <= 1; i++) {
			int temp[] = Arrays.copyOf(degree, N);
			System.out.println(toposort(i));
			degree = temp;
		}

	}

	static int toposort(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
//		for(int i=0; i<N; i++){
//			if(degree[i]==0) {
//				q.add(i);
//			}
//		}
		q.add(start);
		visited[start] = true;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
			int cur = q.poll();
			for (int a : adjlist[cur]) {
				if (!visited[a]) {
					degree[a]--;
					if (degree[a] == 0) {
						q.add(a);
						visited[a]=true;
					}
				}
			}
			}
			depth++;

		}
		return depth;

	}

	static String input1 = "6 6\r\n" + "1 2\r\n" + "2 3\r\n" + "3 4\r\n" + "3 5\r\n" + "3 6\r\n" + "5 2";
}