package Algo_231024;

import java.util.*;

import java.io.*;

public class 예술성_연습 {

	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(input1);
		N = sc.nextInt();
		int map[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

	}

	static void rotation(int arr[][]) {
		int map_copy[][] = new int[N][N];
		for(int i=N/2; i<=N/2; i++) {
			for(int j=0; j<N; j++) {
				
			}
		}

	}

	static String input1 = "5\r\n" + "1 2 2 3 3\r\n" + "2 2 2 3 3\r\n" + "2 2 1 3 1\r\n" + "2 2 1 1 1\r\n"
			+ "2 2 1 1 1";

}
