package Algo_231014;

import java.util.*;
import java.io.*;

public class BJ_1912_MAXISUM {
	   public static void main(String[] args) {
	        Scanner scanner = new Scanner(input2);
	        int n = scanner.nextInt();

	        int[] arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            arr[i] = scanner.nextInt();
	        }

	        int[] dp = new int[n];
	        dp[0] = arr[0]; 

	        for (int i = 1; i < n; i++) {
	            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
	        }

	        int maxSum = dp[0];
	        for (int i = 1; i < n; i++) {
	            if (dp[i] > maxSum) {
	                maxSum = dp[i];
	            }
	        }

	        System.out.println(maxSum);
	    }
	
	
	static String input1 = "10\r\n"
			+ "10 -4 3 1 5 6 -35 12 21 -1";
	static String input2 = "10\r\n"
			+ "2 1 -4 3 4 -4 6 5 -5 1";
	static String input3 = "5\r\n"
			+ "-1 -2 -3 -4 -5";
}