package Algo_230926;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.sql.SQLIntegrityConstraintViolationException;

public class BJ_2606_Virus {
	
	static int E, V;
	static int[] p;
	static int find(int a) {
		if(p[a]!=a) {
			p[a]=find(p[a]);
		}
		return p[a];
	}
	
	static void union(int a, int b) {
		if(a<b) {
		p[find(b)] =p[find(a)];
		}
		else {
			p[find(a)] =p[find(b)];
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(input);
		
		 V = scanner.nextInt();
		 E = scanner.nextInt();
		 p = new int [V+1];
		 for(int i=1; i<=V; i++) {
			 p[i]=i;
		 }
		 for(int i=0; i<E; i++) {
			 union(scanner.nextInt(), scanner.nextInt());
		 }
		int cnt = 0;
		 for(int i =2; i<V; i++) {
			 if(p[i]==1) {
				 cnt++;
			 }
		 }
		 System.out.println(Arrays.toString(p));
		
		
		
	}
	
	static String input = "7\r\n"
			+ "6\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			+ "1 5\r\n"
			+ "5 2\r\n"
			+ "5 6\r\n"
			+ "4 7";
}