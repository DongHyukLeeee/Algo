package Algo_231008;

import java.util.*;
import java.beans.IntrospectionException;
import java.io.*;

public class BJ_21610_마법사_물복사 {

	static int di[] = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int dj[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static boolean[][] cloud;
	static int waterMap[][];
	static int N, M;

	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		waterMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				waterMap[i][j] = sc.nextInt();
			}
		}

		cloud = new boolean[N][N];

		cloud[N - 1][0] = true;
		cloud[N - 1][1] = true;
		cloud[N - 2][0] = true;
		cloud[N - 2][1] = true;
		for (int l = 0; l < M; l++) {
			moveCloud(sc.nextInt() - 1, sc.nextInt());


			
		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if (cloud[i][j]) {
						int cnt = 0;
						for (int k = 1; k < 8; k += 2) {
							int ni = i + di[k];
							int nj = j + dj[k];
							if (ni >= N || nj >= N || ni < 0 || nj < 0)
								continue;
							if (waterMap[ni][nj]>0) {
								cnt++;
							}
						}
						waterMap[i][j] += cnt;

					}
				}
			}


			boolean cloud_copy[][] = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!cloud[i][j]&&waterMap[i][j] >= 2) {
						waterMap[i][j] -= 2;
						cloud_copy[i][j] = true;
					}
				}
			}
			cloud=cloud_copy;


		}
		

		int res=0;
		for (int ii = 0; ii < N; ii++) {
			for (int jj = 0; jj < N; jj++) {
				res+=waterMap[ii][jj];
			}
		}	
		
		System.out.println(res);
	
	}

	static void moveCloud(int direction, int si) {
		// 구름이 이동한 후의 위치를 저장할 배열	
		boolean[][] newCloud = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					// 현재 구름이 이동할 새로운 위치 계산
					int ni = (i + si * di[direction] + 50*N) % N;
					int nj = (j + si * dj[direction] + 50*N) % N;

					// 비가 내리는 위치에 물 증가
					waterMap[ni][nj]++;

					// 현재 위치의 구름은 사라짐
					cloud[i][j] = false;

					// 새로운 위치에 구름 생성
					newCloud[ni][nj] = true;
				}
			}
		}

		// 새로운 구름 배열로 업데이트
		for(int i=0; i<N; i++ ) {
			for(int j=0; j<N; j++) {
				cloud[i][j]=newCloud[i][j];
			}
		}
	}

	static String input1 = "5 4\r\n" + "0 0 1 0 2\r\n" + "2 3 2 1 0\r\n" + "4 3 2 9 0\r\n" + "1 0 2 9 0\r\n"
			+ "8 8 2 1 0\r\n" + "1 3\r\n" + "3 4\r\n" + "8 1\r\n" + "4 8";
}