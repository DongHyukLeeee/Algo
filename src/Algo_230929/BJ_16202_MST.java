package Algo_230929;

import java.util.*;
import java.io.*;

public class BJ_16202_MST {
	static int p[];
	
	static void union(int x, int y) {
		p[find(y)]=p[find(x)];
	}
	static int find(int x) {
		if(p[x]!=x) {
			p[x]=find(p[x]);
		}
		return p[x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int Turn = sc.nextInt();
		p = new int[V+1];
		for(int i=1; i<=V;i++) {
			p[i]=i;
		}
		int edges[][] = new int [E][3];
		
		for(int i=0; i<E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = i+1;
		}
		Arrays.sort(edges, (a,b)->a[2]-b[2]);
		

		ArrayList<Integer> resarr = new ArrayList<Integer>();
		for(int j=0; j<Turn; j++) {
			for(int i=1; i<=V;i++) {
				p[i]=i;
			}
			int cnt = 0;
			int res = 0;
			int index_i = -1;
			for(int i=0; i<E; i++) {
				int a = edges[i][0];
				int b = edges[i][1];
				int c = edges[i][2];
				if(find(a)!=find(b)) {
					union(a, b);
					res+=c;
					if(cnt==0) {
						index_i=i;
					}
					cnt++;
				}
				if(cnt==V-1) {
					break;
				}
			}
			if(cnt!=V-1) {
				resarr.add(0);
			}
			else {
				resarr.add(res);
			}
			edges[index_i][0]=0;
			edges[index_i][1]=0;

		}//Turn
		for(int a : resarr) {
		System.out.printf("%d ", a);
		}
		
		
		

	}
	
	static String input = "6 9 6\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			+ "3 4\r\n"
			+ "4 5\r\n"
			+ "5 6\r\n"
			+ "1 6\r\n"
			+ "1 4\r\n"
			+ "2 5\r\n"
			+ "3 6";
}