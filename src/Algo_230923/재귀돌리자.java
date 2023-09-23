package Algo_230923;


import java.util.Arrays;
import java.util.Scanner;

public class 재귀돌리자 {
    static int M, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        int[] dp = new int[N + 1];

        for (int i = M; i <= N; i++) {
            if (i == M) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 1;
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                }
            }
        }

        System.out.println(dp[N]);
        for(int i=0; i<N+1 ;i++) {
        	System.out.printf("%d %d || ", i, dp[i]);
        }
    }


	
	static String input = "5 17";
}