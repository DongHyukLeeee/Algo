package Algo_230929;

import java.util.*;
import java.io.*;

public class BJ_9344_도로 {
	
	static int p[];
	
	static int find(int x) {
		if(p[x]!=x) {
			p[x]=find(p[x]);
		}
		return p[x];
		
	}
	static void union(int a, int b) {
		p[find(b)]=p[find(a)];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int Tcase = sc.nextInt();
		for(int tc=1; tc<=Tcase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			p = new int[N+1];
			for(int i=1; i<=N; i++) {
				p[i]=i;
			}
			int Edges[][] = new int[M][3];
			for(int i=0; i<M; i++) {
				Edges[i][0] = sc.nextInt();
				Edges[i][1] = sc.nextInt();
				Edges[i][2] = sc.nextInt();
			}
			
			int cnt=0;
			String res="NO";
			
			for(int i=0; i<M; i++) {
				int a = Edges[i][0];
				int b = Edges[i][1];
				int c = Edges[i][2];
				
				if(find(a)!=find(b)) {
					union(a, b);
					cnt++;
					if(a==x&&b==y) {
						res="YES";
					}
					if(b==x&&a==y) {
						res="YES";
					}
				}
				if(cnt==N-1) {
					break;
				}
				
			}
			
			
	
			System.out.println(res);
		
		}
	}
	
	static String input = "3\r\n"
			+ "2 1 1 2\r\n"
			+ "1 2 4\r\n"
			+ "3 3 2 3\r\n"
			+ "1 2 1\r\n"
			+ "1 3 2\r\n"
			+ "2 3 3\r\n"
			+ "4 5 3 4\r\n"
			+ "1 2 1\r\n"
			+ "1 3 3\r\n"
			+ "3 4 2\r\n"
			+ "1 4 4\r\n"
			+ "4 2 5";
}