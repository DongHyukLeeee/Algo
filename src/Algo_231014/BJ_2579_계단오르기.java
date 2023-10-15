package Algo_231014;

import java.util.*;
import java.io.*;

public class BJ_2579_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int [] d = new int[N];
		   d[0] = arr[0];
	       d[1] = arr[0] + arr[1];
		for(int i=2; i<N; i++) {
			d[i]=Math.max(d[i-2]+arr[i],d[i-1]);
		}
		System.out.println(d[N-1]);
	}
	
	static String in1 = "6\r\n"
			+ "10\r\n"
			+ "20\r\n"
			+ "15\r\n"
			+ "25\r\n"
			+ "10\r\n"
			+ "20";
}