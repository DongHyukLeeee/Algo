package Algo_231002;

import java.util.*;
import java.io.*;

public class BJ_12865_배낭복습 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(input1);
		int N = sc.nextInt();
		int maxWeight = sc.nextInt();
		int dp[][] = new int[N + 1][maxWeight + 1];
		int weights[] = new int[N + 1];
		int values[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			values[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				if(j>=weights[i]) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-weights[i]]+values[i]);	
				}

			}
		}
		System.out.println(dp[N][maxWeight]);
		System.out.println(Arrays.toString(weights));
		System.out.println(Arrays.toString(values));
	}

	static String input1 = "4 7\r\n" + "6 13\r\n" + "4 8\r\n" + "3 6\r\n" + "5 12";
}