package Algo_230924;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruscal {

	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수 0부터 시작한다.
		int E = sc.nextInt(); // 간선의 수

		// 간선배열을 만들어서 저장을 할건데 (사용자 정의 클래스 / 2차원 배열을 가지고)
		// 2차원 배열 이요해서 만들어보자~ ( [0]:시작정점 [1]:끝정점 [2]:가중치)
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		} // 입력끝

		// 크루스칼 1단계 : 간선을 정렬(오름차순)
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

//		for(int[] e : edges) {
//			System.out.println(Arrays.toString(e));
//		} //아주 잘 정렬된게 딱 보였어~~

		// 크루스칼 2단계 : V-1개의 간선을 뽑아야 하는데, 사이클이 발생안하도록 뽑아~!
		p = new int[V];
		// 2-1. make-set 하자
		for (int i = 0; i < V; i++) {
//			makeset(i);
			p[i] = i;
		}

		// 2-2. 검사하면서 뽑아
		int ans = 0; // 최소비용을 저장할 친구.
		int pick = 0; // 뽑은 간선의 수를 저장할 친구

		// while을 쓰겠다라고하면 edges 배열을 돌릴 index 변수가 하나 필요하다.
		// for문을 이용해서 쓰면 if문을 통해 break를 걸어줘야 겠다(선택)
		for (int i = 0; i < E; i++) {
			// i번째 간선 이용하여 두개의 정점을 가지고 처리하겠다.
//			int x = edges[i][0];
//			int y = edges[i][1];

			int px = findset(edges[i][0]);
			int py = findset(edges[i][1]);

//			if (findset(x) != findset(y)) {
			if (px != py) {
				// 여기에 들어왔다라는 뜻은 사이클이 형성이 안된다라는 뜻
//				union(x, y);
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			if (pick == V - 1)
				break;
		}
		System.out.println(ans);

	}

	static void union(int x, int y) {
//		p[findset(y)] = findset(x); // x의 대표를 y의 대표로 넣겠다. rank고려x
		p[y] = x; //허나! 이렇게 작성하는 것은 문제를 잘 이해했고 확신이 있을때 하는 행위
	}

	static int findset(int x) {
		// 효율성 따지지 않은 순수 그잡채 기술
//		if(x == p[x]) return x;
//		return findset(p[x]);

		// 패쓰 컴푸레숀~~~
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];

	}

	static void makeset(int i) {
		p[i] = i;
		// rank는 따로 하지는 않겠습니다.
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";
}
