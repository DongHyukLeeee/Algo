import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo2_서울_7반_이동혁 {
	static int i_s, i_f, j_s, j_f, N, M;
	static int map[][];

	
	//Queue서 쓸 포인트입니다
	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		// BFS(Queue)로 풀어보겠습니다. 끝까지 구현해볼지는 모르겠습니다....
		Scanner sc = new Scanner(System.in);
		int Tcase = sc.nextInt();
		for (int tc = 1; tc <= Tcase; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];
			// i_start ~ j_finish
			i_s = sc.nextInt();
			i_f = sc.nextInt();
			j_s = sc.nextInt();
			j_f = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			System.out.println("#" + tc + " Sorry...");
		}
		sc.close();

	}

	static boolean bfs() {
		boolean visited[][] = new boolean[N][M];
		//Queue로 순회할 것임.
		Queue<point> q = new LinkedList<>();
		//출발점을 add
		q.add(new point(i_s,j_s));
		//출발점 방문처리
		visited[i_s][j_s]=true;
		
		
		while(!q.isEmpty()) {
			point cur = q.poll();
			int curx = cur.x;
			int cury = cur.y;
			int [] di = {0};
			int [] dj = {0};
			//0이아닐 경우만 di,dj 반환, 0일경우 di, dj를 null,null이런 이상한식으로 받아야 하는데, 에러가 뜰 위험이 매우 큼
			if(map[curx][cury]!=0) {
				findDirection(map[curx][cury],di,dj);
				
				for(int i=0; i<di.length; i++) {
					int ni = curx + di[i];
					int nj = cury + dj[i];
					if(ni<0||nj<0||ni>=N||nj>=N) continue;
					if(!visited[ni][nj]&&)
						
					//여기까지가 한계인가 봅니다.. ni,nj는 설정해줘도 뒤에 map[curx][cury]랑 map[ni][nj]를 매칭하지 못하겠습니다.
					//주말내내 DFS BFS 골드 문제 죽도록 풀었는데 이문제는 너무한것 같습니다..ㅠ 백준 문제난이도 플레티넘 이상체감입니다 ㅠㅠ
				
				}
				
			}
			
		}
		
		
		
		return false;
		
	}

	// map[curx][cury]에따라서 Direction을 잡아보려고 했습니다.
	static void findDirection(int a, int di[], int dj[]) {

		switch (a) {
		case 1:
			int[] ni1 = { 0, 0 };
			int[] nj1 = { 1, -1 };
			di = ni1;
			dj = nj1;
			break;
		case 2:
			int[] ni2 = { 1, -1 };
			int[] nj2 = { 0, 0 };
			di = ni2;
			dj = nj2;
			break;
		case 3:
			int[] ni3 = { 1, 0 };
			int[] nj3 = { 0, 1 };
			di = ni3;
			dj = nj3;
			break;
		case 4:
			int[] ni4 = { 1, 0 };
			int[] nj4 = { 0, -1 };
			di = ni4;
			dj = nj4;
			break;
		case 5:
			int[] ni5 = { 1, -1 };
			int[] nj5 = { 0, 0 };
			di = ni5;
			dj = nj5;
			break;
		case 6:
			int[] ni6 = { 0, -1 };
			int[] nj6 = { 1, 0 };
			di = ni6;
			dj = nj6;
			break;
		case 7:
			int[] ni7 = { 0, 0, -1, 1 };
			int[] nj7 = { -1, 1, 0, 0 };
			di = ni7;
			dj = nj7;
			break;
		}

	}

}
