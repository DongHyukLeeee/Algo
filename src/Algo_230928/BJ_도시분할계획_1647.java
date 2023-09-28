package Algo_230928;

import java.util.*;
import java.io.*;

public class BJ_도시분할계획_1647 {
	
	static int find(int a) {
		if(a!=p[a]) {
			p[a]=find(p[a]);
		}
		return p[a];
		
	}
	
	static void union(int a, int b) {
		p[find(b)]=p[find(a)];
		
	}
	
	static int p[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(input);
		
		int V =sc.nextInt();
		int E =sc.nextInt();
		
		p = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			p[i] = i;
		}
		
		int [][] Edges = new int[E][3];
		
		for(int i=0; i<E; i++) {
			Edges[i][0] = sc.nextInt();
			Edges[i][1] = sc.nextInt();
			Edges[i][2] = sc.nextInt();
		}
		Arrays.sort(Edges , (a,b) ->a[2]-b[2] );
		
		int res = 0;
		int cnt = 0;
		for(int i=0; i<E; i++) {
			int a = Edges[i][0] ;
			int b = Edges[i][1] ;
			int c = Edges[i][2] ;
			
			if(find(a)!=find(b)) {
				if(cnt==V-2) {
				union(a, b);
				cnt++;
				}
				else {
				union(a, b);
				res+=c;
				cnt++;
				}
			}
			if(cnt==V-1) {
				break;
			}
		
			
		}
		
		System.out.println(res);

	}
	
	static String input = "7 12\r\n"
			+ "1 2 3\r\n"
			+ "1 3 2\r\n"
			+ "3 2 1\r\n"
			+ "2 5 2\r\n"
			+ "3 4 4\r\n"
			+ "7 3 6\r\n"
			+ "5 1 5\r\n"
			+ "1 6 2\r\n"
			+ "6 4 1\r\n"
			+ "6 5 3\r\n"
			+ "4 5 3\r\n"
			+ "6 7 4";
}