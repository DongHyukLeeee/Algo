package Algo_2310007;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;


public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		
		int N = sc.nextInt();
		List<List<Integer>> melodiesList = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0; i<N ;i++) {
			int a= sc.nextInt();
			List<Integer> song  = new ArrayList<>();
			for(int j=0; j<a; j++) {
				song.add(sc.nextInt());
			}
			melodiesList.add(song);
		}
		int M = sc.nextInt();
		int target[] = new int[M];
		for(int i=0; i<M; i++) {
			target[i]=sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			if(kmp(melodiesList.get(i), target)) {
				res.add(i+1);
			}
		}
		if(res.size()==0) {
			System.out.println(-1);
		}
		else {
		for(int a: res) {
			System.out.println(a);
		}
		}
		
		System.out.println(Arrays.toString(setpi(target)));
		System.out.println(Arrays.toString(setpi(melodiesList.get(0))));
		System.out.println(Arrays.toString(setpi(melodiesList.get(1))));
		System.out.println(Arrays.toString(setpi(melodiesList.get(2))));
		System.out.println(Arrays.toString(setpi(melodiesList.get(3))));
		System.out.println(Arrays.toString(setpi(melodiesList.get(4))));
		
	}
	
	static int[] setpi(int[] target) {
		int pi[] = new int[target.length];
		int j=0;
		
		for(int i=1; i<target.length; i++) {
			
			while(j>0&&target[i]!=target[j]) {
				j=pi[j-1];
			}
			if(target[i]==target[j]) {
				pi[i]=++j;
			}
		
		}
		
		return pi;
	}
	static int[] setpi(List<Integer> target) {
		int pi[] = new int[target.size()];
		int j=0;
		
		for(int i=1; i<target.size(); i++) {
			
			while(j>0&&target.get(i)!=target.get(j)) {
				j=pi[j-1];
			}
			if(target.get(i)==target.get(j)) {
				pi[i]=++j;
			}
			
		}
		
		return pi;
	}
	
	static boolean kmp(List<Integer> full, int [] target) {
		int [] pi = setpi(target);
		int j=0;
		
		for(int i=0; i<full.size(); i++) {
			while(j>0&&full.get(i)!=target[j]) {
				j=pi[j-1];
			}
			if(full.get(i)==target[j]) {
				if(j==target.length-1) {
					j=pi[j];
					return true;
				}
				else {
					j++;
				}
				
			}
		}
		return false;

		
	}
	
	
	
	
	static String input1 = "6\r\n"
			+ "8 1 2 1 2 1 3 3 1\r\n"
			+ "4 10 10 10 10\r\n"
			+ "6 6 4 5 4 5 6\r\n"
			+ "7 3 4 9 1 2 5 3\r\n"
			+ "2 3 4\r\n"
			+ "6 3 4 3 4 5 5\r\n"
			+ "4\r\n"
			+ "1 2 1 2";
//	static String input1 = "6\r\n"
//			+ "8 1 2 3 1 1 3 3 1\r\n"
//			+ "4 10 10 10 10\r\n"
//			+ "6 6 4 5 4 5 6\r\n"
//			+ "7 3 4 9 1 2 5 3\r\n"
//			+ "2 3 4\r\n"
//			+ "6 3 4 3 4 5 5\r\n"
//			+ "4\r\n"
//			+ "1 2 1 2";
}