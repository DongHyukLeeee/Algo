package Algo_231023;

import java.util.*;

import java.io.*;

public class _3회차월말평가_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);

		int Tcase = sc.nextInt();

		for (int tc = 1; tc <= Tcase; tc++) {

			int N = sc.nextInt();

			int map[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int sumAllDoTory[] = new int[N];
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					sumAllDoTory[j] += map[i][j];
				}
			}
			int maxi = Integer.MIN_VALUE;
			for (int msk = 0; msk < 1 << N; msk++) {
				if (Integer.bitCount(msk) == 3) {
					int temp = 0;
					int sum = 0;
					for (int i = 0; i < N; i++) {
						if ((msk & 1 << i) > 0) {
							if (temp == 1) {
								sum += sumAllDoTory[i] / 2;
								temp++;
								} else {
								sum += sumAllDoTory[i];
								temp++;
							}
						}
					}
					maxi = Math.max(maxi, sum);

				}

			}

			System.out.println("#" + tc + " " + maxi);
		}
	}

	static String input1 = "3\r\n" + "3\r\n" + "1 0 1\r\n" + "0 0 0\r\n" + "1 0 1\r\n" + "3\r\n" + "1 1 0\r\n"
			+ "1 1 0\r\n" + "1 1 0\r\n" + "5\r\n" + "0 0 0 0 1\r\n" + "1 0 0 1 0\r\n" + "1 0 0 0 1\r\n"
			+ "0 0 1 0 1\r\n" + "1 1 0 1 0\r\n" + "" + "";

}
