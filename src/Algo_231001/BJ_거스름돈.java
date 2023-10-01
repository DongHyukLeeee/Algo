package Algo_231001;

import java.util.*;
import java.io.*;

public class BJ_거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 거스름돈 금액

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1); // 최대값으로 초기화
        dp[0]=0;
        int[] coins = {2,5};
        for(int coin : coins) {
        	for(int j=coin; j<=n; j++) {
        		dp[j]=Math.min(dp[j], dp[j-coin]+1);
        	}
        }
        
        System.out.println(dp[n]);
    }
}