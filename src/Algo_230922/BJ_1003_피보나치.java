package Algo_230922;


import java.util.Arrays;
import java.util.Scanner;

public class BJ_1003_피보나치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dp[] = new int [40];
		dp[1]=0;
		dp[2]=1;
		for(int i=3; i<40; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}

		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			int temp = sc.nextInt();
			if(temp==0) {
				System.out.println("1"+ " " + "0" );
			}
			else if(temp==1) {
				System.out.println("0"+ " " + "1");
			}
			else {
			System.out.printf("%d %d" , dp[temp],dp[temp+1]);
			System.out.println();
		
			}
		}
	}
	
	static String input = "3\r\n"
			+ "0\r\n"
			+ "1\r\n"
			+ "3";

}