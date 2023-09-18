package Algo_230916;

import java.util.*;

public class BJ_퇴사 {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr1[] = new int [N];
		int arr2[] = new int [N];
		for(int i=0;i<N;i++ ) {
			arr1[i]=sc.nextInt();
			arr2[i]=sc.nextInt();
			
		}
			
		int maxi = -9999;
		
		//0~7 
		for(int msk = 0; msk< 1<<arr1.length; msk++) {
		ArrayList <Integer> list = new ArrayList();
			boolean isOk =true;
			for(int i=0; i<arr1.length; i++) {
			if((msk& 1<<i)>0) 
			{
				list.add(i);
			
			}	
			}
			for(int i=0; i<list.size()-1; i++) {
				if(list.get(i+1)-list.get(i)<arr1[list.get(i)]) {
					isOk = false;
					break;
				}
			}
			for(int i=0; i<list.size(); i++) {
				if(arr1[list.get(i)]+list.get(i)>arr1.length) {
					isOk = false;
					break;
				}
			}
			if(isOk) {
				int sum = 0;
				for(int i=0; i<list.size(); i++) {
					sum += arr2[list.get(i)];
				}
				maxi =Math.max(sum, maxi);
			}
		
		}
		
		System.out.println(maxi);
		}
	

}
