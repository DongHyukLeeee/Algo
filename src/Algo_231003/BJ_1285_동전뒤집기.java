package Algo_231003;

import java.util.*;


import java.io.*;

public class BJ_1285_동전뒤집기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc =new Scanner(input1);
		N = sc.nextInt();
		
		char arr[][] = new char [N][N];
		for(int i=0; i<N;i++) {
			String temp =sc.next();
			for(int j=0; j<N;j++) {
				arr[i][j]=temp.charAt(j);
			}
		}
		
		char arr_copy[][] = new char [N][N];
		for(int i=0; i<N;i++) {
			for(int j=0; j<N;j++) {
				arr_copy[i][j]=arr[i][j];
			}
		}
		
		int MinimumTails = Integer.MAX_VALUE;
		for(int mski=0; mski<1<<N; mski++) {
			for(int mskj=0; mskj<1<<N; mskj++) {
				if(Integer.bitCount(mski)<=1&&Integer.bitCount(mskj)<=1) {
					for(int i=0; i<N;i++) {
						for(int j=0; j<N;j++) {
							arr[i][j]=arr_copy[i][j];
						}
					}
					
					for(int k=0; k<N; k++) {
						if((mski&k)>0) {
							flipTheCoin(arr[k]);
						}
					}
					for(int l=0; l<N; l++)
						if((mski&l)>0) {
						flipTheCoin_j(arr,l);
					}
					MinimumTails = Math.min(howManyTails(arr),MinimumTails );
				}
			}
		}
		
		
		System.out.println(MinimumTails);
	}
	
	static void flipTheCoin(char arr[]) {
		

		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='T') {
				arr[i]='H';
			}
			else if(arr[i]=='H') {
				arr[i]='T';
			}
		}
		
	}
	static void flipTheCoin_j(char arr[][] ,int j) {
		
		for(int i=0; i<N; i++) {
			if(arr[i][j]=='T') {
				arr[i][j]='H';
			}
			else if(arr[i][j]=='H') {
				arr[i][j]='T';
			}
		}
	}
	
	static int howManyTails(char arr[][]) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='T') cnt++;
			}
			
		}
		return cnt;
	}
	static String input1 = "3\r\n"
			+ "HHT\r\n"
			+ "THH\r\n"
			+ "THT";
}