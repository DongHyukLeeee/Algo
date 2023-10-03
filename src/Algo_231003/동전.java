package Algo_231003;

import java.util.*;
import java.io.*;

public class 동전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int target = sc.nextInt();
		int[] coins = new int[N];
		for(int i=0; i<N; i++) {
			coins[i]=sc.nextInt();
		}
		int dp[] = new int[target+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0]=0;
		for(int i=0; i<coins.length; i++) {
			for(int j=coins[i]; j<=target; j++) {
				dp[j]=Math.min(dp[j], dp[j-coins[i]]+1);
			}
		}
		if(dp[target]==Integer.MAX_VALUE-1) {
			dp[target]=-1;
		}
		System.out.println(dp[target]);
	}
}