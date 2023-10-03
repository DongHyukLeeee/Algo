package Algo_231002;

import java.util.*;
import java.io.*;

public class BJ_2839_설탕배달_dp {
	public static void main(String[] args) {
		
		int N = 4;
		int dp[] = new int[N+1];
		int bags[] = {3,5};
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0]=0;
		for(int i=0; i<2; i++) {
			for(int j=bags[i]; j<=N; j++) {
				dp[j]=Math.min(dp[j], dp[j-bags[i]]+1);
			}
		}
		if(dp[N]==Integer.MAX_VALUE-1) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[N]);
		}
	}
}