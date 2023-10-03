package Algo_231002;

import java.util.*;
import java.io.*;

public class 연습장24 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int N = sc.nextInt();
		int arr[] = new int[N+1];
		int dpH[] = new int[N+1];
		int dpL[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.fill(dpH, 1);
		Arrays.fill(dpL, 1);
		for(int i=2; i<=N; i++) {
			for(int j=i; j>=1; j--) {
				if(arr[i]>arr[j]) {
					dpH[i]=getMax(dpH[i], dpH[j]+1);
				}
			}
		}
		for(int i=N-1; i>=1; i--) {
			for(int j=i; j<=N; j++) {
				if(arr[i]>arr[j]) {
					dpL[i]=getMax(dpL[i], dpL[j]+1);
				}
			}
		}
		
		int maxi = 0;
		
		for(int i=1; i<N ;i++) {
			
			maxi = Math.max(maxi,dpH[i]+dpL[i]);
		}
		maxi -=1;


		System.out.println(maxi);
		System.out.println(Arrays.toString(dpL));
		System.out.println(Arrays.toString(dpH));

	}
	
	static int getMax(int a, int b) {
		if(a>b) {
			return a;
		}
		else {
			return b;
		}
		
	}
	static String input = "10\r\n"
			+ "1 5 2 1 4 3 4 5 2 1";
}