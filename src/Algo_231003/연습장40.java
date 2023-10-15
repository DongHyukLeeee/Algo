package Algo_231003;

import java.util.*;
import java.io.*;

public class 연습장40 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input1);

		int N = sc.nextInt() ;
		int electricLinesfrom [] = new int[501];
		int electricLinesto [] = new int[501];
		
		for(int i=0; i<N; i++) {
			electricLinesfrom[sc.nextInt()]++;
			electricLinesto[sc.nextInt()]++;
		}
		
		System.out.println(Arrays.toString(electricLinesfrom));
		System.out.println(Arrays.toString(electricLinesto));
	}
	
	static String input1 = "8\r\n"
			+ "1 8\r\n"
			+ "3 9\r\n"
			+ "2 2\r\n"
			+ "4 1\r\n"
			+ "6 4\r\n"
			+ "10 10\r\n"
			+ "9 7\r\n"
			+ "7 6";
}