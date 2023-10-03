package Algo_231002;

import java.util.*;
import java.io.*;

public class BJ_14916_거스름돈_복습 {
	public static void main(String[] args) {

		int N = 13;
		int coins[] = {2,5};
		int [] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0]=0;
		for(int i=0; i<2; i++) {
			for(int j= coins[i]; j<=N; j++) {
				dp[j] = Math.min(dp[j],dp[j-coins[i]]+1 );
			}
		}
		
		System.out.println(Arrays.toString(dp));
	}
	
}