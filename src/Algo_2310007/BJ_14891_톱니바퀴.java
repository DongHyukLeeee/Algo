package Algo_2310007;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;


public class BJ_14891_톱니바퀴 {
	
	static int res= 0;
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		String text = "ABCABCABCAAABB";
		
		String target = "AB";
		
		
		kmp(text, target);
		System.out.println(res);
		
		
		
	}
	
	static int[] setpi(String target) {
		
		int[] pi = new int [target.length()];
		
		int j=0;
		for(int i=1; i<target.length(); i++) {
			while(j>0&&target.charAt(i)!=target.charAt(j)) {
				j=pi[j-1];
			}
			if(target.charAt(i)==target.charAt(j)) {
				j++;
			}
			pi[i]=j;
			
		}
		
		
		return pi;
	}
	
	static void kmp(String text, String target) {
		int j=0;
		int pi[] = setpi(target);
		
		for(int i=0; i<text.length(); i++) {
			while(j>0&&text.charAt(i)!=target.charAt(j)) {
				j=pi[j-1];
			}
			if(text.charAt(i)==target.charAt(j)) {
				if(j==target.length()-1) {
					res++;
					System.out.println(i-j+1);
					j=pi[j];
				}
				else {
					j++;
				}
			}
			
		}
		
	}
	
}