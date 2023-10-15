package Algo_231014;

import java.util.*;
import java.io.*;

public class BJ9252_LCS2 {
	static int[][] dp;
	static String a,b;
	static String res = "";
	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(in1);
		
		 a = scanner.next();
		 b = scanner.next();
		 dp = new int[a.length()+1][b.length()+1];

		 for(int i=1; i<=a.length(); i++) {
			 for(int j=1; j<=b.length(); j++) {
				 if(a.charAt(i-1)==b.charAt(j-1)) {
					 dp[i][j]=dp[i-1][j-1]+1;
				 }
				 else {
					 if(dp[i-1][j]>dp[i][j-1]) {
					 dp[i][j]=dp[i-1][j];
					 }
					 else {
					 dp[i][j]=dp[i][j-1];
					 } 
					 
				 }
			 }
		 }
		 System.out.println(dp[a.length()][b.length()]);
	     findString(a.length(), b.length());
		 System.out.println(res);
		 

	}
	
	static void findString(int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (a.charAt(i - 1) == b.charAt(j - 1)) {
            findString(i - 1, j - 1);
            res += a.charAt(i - 1);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                findString(i - 1, j);
            } else {
                findString(i, j - 1);
            }
        }
    }
	static String in1 = "ACAYKP\r\n"
			+ "CAPCAK";
}