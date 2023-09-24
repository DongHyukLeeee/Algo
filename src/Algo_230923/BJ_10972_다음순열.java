package Algo_230923;

import java.util.*;
import java.io.*;

public class BJ_10972_다음순열 {
	static int N;
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(input);
	
	N =sc.nextInt();
	ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
	int arr[]  = new int [N];
	for(int i=0; i<N;i++) {
		arr[i] = sc.nextInt();
	}
	
	int arrCopy[] = new int [N];
	for(int i=0; i<N ;i++) {
		arrCopy[i] = arr[i];
	}
	Arrays.sort(arrCopy);
	ArrayList<Integer> temp = new ArrayList<>();

	
	dfs(arrCopy,arrList,temp );
	
	int index = -1;
	for(int i=0; i<arrList.size(); i++) {
		boolean check = false;
		for(int j=0; j<N; j++) {
			if(arrList.get(i).get(j)==arr[j]){
				check =true;
			}
			else {
				check =false;
				break;
			}
			
		}
		if(check) {
			index=i;
		}
	}
	if(index!=arrList.size()-1) {
		for(int a : arrList.get(index+1)) {
			System.out.printf("%d ",a);
		}
	}
	else {
		System.out.println("-1");
	}
	}
	
	public static void dfs(int [] arr, ArrayList<ArrayList<Integer>> arrList, ArrayList<Integer> current ) {
		if(current.size()==N) {
			arrList.add(new ArrayList<Integer>(current));
		}
		
	
	
	for(int i=0; i<N; i++) {
		if(!current.contains(arr[i])) {
		ArrayList<Integer> newCurrent = current;
		newCurrent.add(arr[i]);
		dfs(arr, arrList ,newCurrent);
		current.remove(current.size()-1);
		}
	} 
	
	}
	
	static String input = "4\r\n"
			+ "1 2 3 4";
}