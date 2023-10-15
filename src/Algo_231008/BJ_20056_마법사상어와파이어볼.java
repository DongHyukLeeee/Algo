package Algo_231008;

import java.util.*;
import java.io.*;

public class BJ_20056_마법사상어와파이어볼 {

	static int di[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dj[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M, K;

	static class fireBall {
		int r, c, m, s, d;

		public fireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		List<fireBall>[][] list = new ArrayList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				list[i][j]=new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			list[a - 1][b - 1].add(new fireBall(a - 1, b - 1, c, d, e));
		}
		
		List<fireBall>[][] list_copy = new ArrayList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(list[i][j].size()!=0) {
					fireBall cur = list[i][j].get(0);
					int curr = cur.r;
					int curc = cur.c;
					int curm = cur.m;
					int curs = cur.s;
					int curd = cur.d;
					
					int nr = (curr+di[curd]+1000*N)%N;
					int nc = (curc+dj[curd]+1000*N)%N;
					list[nr][nc].add(new fireBall(nr, nc, curm, curs, curd));
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if(list[i][j].size()!=0) {
//					System.out.printf("In ");
//				}
//				else{
//					System.out.printf("- ");
//				}
//			}
//			System.out.println();
//
//		}

//		while (!queue.isEmpty()) {
//			int size = queue.size();
//			for (int i = 0; i < size; i++) {
//				fireBall cur = queue.poll();
//				int curr = cur.r;
//				int curc = cur.c;
//				int curm = cur.m;
//				int curs = cur.s;
//				int curd = cur.d;
//
//				int nr = (curr + curs * di[curd] + 1000 * N) % N;
//				int nc = (curc + curs * dj[curd] + 1000 * N) % N;
//				map[nr][nc] += 1;
//
//			}
//
//		}

	}

	static String input1 = "4 2 1\r\n" + "1 1 5 2 2\r\n" + "1 4 7 1 6";

}
