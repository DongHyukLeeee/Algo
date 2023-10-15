package Algo_2310007;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.w3c.dom.ls.LSException;


public class Main {
	
	static int cnt=0 ;
	static ArrayList<Integer> list;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input1);
		
		
		String text = sc.nextLine();
		String target = sc.nextLine();
		list = new ArrayList<>();
		kmp(text, target);
		System.out.println(cnt);
		for(int a : list) {
			System.out.println(a);
		}

	}

	static int[] setpi(String target) {
		int [] pi = new int[target.length()];
		
		int j=0;
		for(int i=1; i<target.length(); i++) {
			while(j>0&&target.charAt(i)!=target.charAt(j)) {
				j= pi[j-1];
				
			}
			if(target.charAt(i)==target.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
	}

	static void kmp(String text, String target) {
		
		int pi[] = setpi(target);
		int j=0;
		for(int i=0; i<text.length(); i++) {
			while(j>0&&text.charAt(i)!=target.charAt(j)) {
				j=pi[j-1];
			}
			if(text.charAt(i)==target.charAt(j)) {
				if(j==target.length()-1) {
					cnt++;
					list.add(i-j+1);
					j=pi[j];
				}
				else {
					j++;
				}
			}

		}
		
	}
	
	static String input1 = "ABC ABCDAB ABCDABCDABDE\r\n"
			+ "ABCDABD";

}
