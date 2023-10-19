package Algo_231019;

import java.util.*;

import java.io.*;

	
public class BJ_2512_예산 {
	
	static int N,maxi,mini;
	static int[] arr;
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(input1);
	
	N = sc.nextInt();
	arr =new int[N];
	maxi = Integer.MIN_VALUE;
	mini = Integer.MAX_VALUE;
	for(int i=0; i<N; i++) {
		arr[i]=sc.nextInt();
		maxi = Math.max(maxi, arr[i]);
		mini = Math.min(mini, arr[i]);
	}
	int limit = sc.nextInt();
	
	System.out.println(maxi);
	System.out.println(mini);
	
	int mid  = (maxi+mini)/2;
	int res = Integer.MIN_VALUE;
	while(true) {
		int sum=0;
		for(int i=0; i<N ;i++) {
			if(arr[i]>mid) {
				sum+=mid;
			}
			else {
				sum+=arr[i];
			}

		}
		if(sum==limit) {
			System.out.println(sum);
			break;
		}
		if(sum>limit) {
			mid=(mid+mini)/2;
		}
		else {
			mid=(mid+maxi)/2;
			res=Math.max(sum, res);
		}
		
	}
	System.out.println(res);
	
		
			
	
	
	}
	static String input1 ="4\r\n" + 
			"120 110 140 150\r\n" + 
			"485";
}