package Algo_231002;

import java.util.*;
import java.io.*;

public class BJ_11659_구간합구하기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int dp[] = new int[N];
		int temp = 0;
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			dp[i]=a+temp;
			temp = temp+a;
		}
		for(int i=0; i<M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			if(a==0) {
				System.out.println(dp[b]);
			}
			else {
				System.out.println(dp[b]-dp[a-1]);
			}

		}
		

	}
	static String input = "5 3\r\n"
			+ "5 4 3 2 1\r\n"
			+ "1 3\r\n"
			+ "2 4\r\n"
			+ "5 5";
}