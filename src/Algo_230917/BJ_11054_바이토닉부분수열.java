package Algo_230917;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BJ_11054_바이토닉부분수열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int maxiSize = 0;
		int maxOfArray = Integer.MIN_VALUE;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			maxOfArray = Math.max(arr[i], maxOfArray);
		}
		for (int i = 0; i < N; i++) {
			if(arr[i]==maxOfArray) {
				list.add(i);
			}
		}
		
		for(int i=0; i<1; i++) {
			int maxIndex = list.get(i);

			for(int k=0; k<N ; k++) {
				int cnt =1;    
			for(int j=k; j<N; j++) {
				int tmp = arr[k];
				if(j<maxIndex) {
					if(tmp<arr[j]) {
						cnt++;
						tmp = arr[j];
					}
				}
				else if(j>maxIndex) {
					if(tmp>arr[j]) {
						cnt++;
						tmp = arr[j];
					}
				}
				maxiSize = Math.max(maxiSize,cnt);
			}
			
		}
		}

		System.out.println(maxiSize);
	}
}