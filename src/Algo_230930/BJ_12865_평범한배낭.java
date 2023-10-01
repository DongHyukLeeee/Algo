package Algo_230930;

import java.util.Scanner;

public class BJ_12865_평범한배낭 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(input);
        int N = scanner.nextInt();  // 물품의 수
        int K = scanner.nextInt();  // 배낭의 무게 제한
        int[] weights = new int[N + 1];  // 물건의 무게 배열
        int[] values = new int[N + 1];  // 물건의 가치 배열

        // 물건의 무게와 가치 입력
        for (int i = 1; i <= N; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        int[][] dp = new int[N + 1][K + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        // 배낭에 넣을 수 있는 물건들의 가치합 출력
        System.out.println(dp[N][K]);
    }


	static String input = "4 7\r\n"
			+ "6 13\r\n"
			+ "4 8\r\n"
			+ "3 6\r\n"
			+ "5 12";
}