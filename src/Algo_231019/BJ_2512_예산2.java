package Algo_231019;

import java.util.*;

import java.io.*;

	
public class BJ_2512_예산2 {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int M =sc.nextInt();
		int res = Integer.MIN_VALUE;
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		for(int msk=0; msk<1<<N; msk++) {
			if(Integer.bitCount(msk)==M) {
				ArrayList<Integer> idx = new ArrayList<>();

				for(int i=0; i<N; i++) {	
					if((msk&1<<i)>0) {
						idx.add(i);
					}
				}
				boolean visited[] = new boolean[N];
				for(int a : idx) {
					visited[a]=true;
				}
				int k = 0;
				ArrayList<Integer> temp = new ArrayList<>();
				ArrayList<Integer> temp2 = new ArrayList<>();
				int tempmaxi =Integer.MIN_VALUE;
				while(k<N) {
					temp.add(arr[k]);
					if(k==N-1||visited[k+1]) {
						int mini = Integer.MAX_VALUE;
						int maxi = Integer.MIN_VALUE;
						for(int x: temp) {
							mini = Math.min(mini, x);
							maxi = Math.max(maxi, x);
						}
						res = Math.max(maxi-mini, res);
						if(maxi-mini!=0) {temp2.add(maxi-mini);
						tempmaxi= Math.max(maxi-mini, tempmaxi);
						
						}
						temp.clear();
					}
					
					
					k++;
				}
				res=Math.min(tempmaxi, res);
			}
		}
		
		System.out.println(res);
		
		
	}
	
	
	static String input1 = "8 3\r\n" + 
			"1 5 4 6 2 1 3 7";
	static String input2 = "4 2\r\n" + 
			"1 1 1 1";
	static String input3 = "7 4\r\n" + 
			"1 2 3 1 2 3 1";
	static String input4 = "5 1\r\n" + 
			"1 100 99 2 3";
	static String input5 = "5 2\r\n" + 
			"1 100 99 2 3";
	
}