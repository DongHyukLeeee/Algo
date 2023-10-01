package Algo_230930;

import java.util.*;
import java.io.*;

public class BJ_Coin {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int Tcase= sc.nextInt();
		
		for(int tc=0; tc<Tcase; tc++) {
			
			int N = sc.nextInt();
			int[] coins = new int[N];
			for(int i=0; i<N; i++) {
				coins[i] = sc.nextInt();
			}
			int M = sc.nextInt();
			int [] dp = new int[M+1];
			
			dp[0] =1;
			for(int i=0; i<N; i++) {
				for(int j=coins[i]; j<=M; j++) {
					dp[j]+=dp[j-coins[i]];
				}
			}
			
			
			System.out.println(dp[M]);
			
			
		}
		

	}
	
	static String input = "3\r\n"
			+ "2\r\n"
			+ "1 2\r\n"
			+ "1000\r\n"
			+ "3\r\n"
			+ "1 5 10\r\n"
			+ "100\r\n"
			+ "2\r\n"
			+ "5 7\r\n"
			+ "22";
}