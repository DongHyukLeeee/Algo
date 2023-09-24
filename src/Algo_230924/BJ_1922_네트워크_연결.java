package Algo_230924;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BJ_1922_네트워크_연결 {
	static int V,E;
	static int[] p;
	
	static int set(int x) {
		if(x!=p[x]) {
			p[x] = set(p[x]);
		}
		return p[x];
	}
	
	static void union(int x, int y) {
		if(x<y) {
		p[set(y)]=set(x);}
		else {
			p[set(x)]=p[set(y)];
		}
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		p= new int[V+1];
		
		for(int i=1; i<V+1; i++) {
			p[i]=i;
		}
		int edges[][] = new int[E][3];
		
		for(int i=0; i<E; i++) {
			edges[i][0]=sc.nextInt();
			edges[i][1]=sc.nextInt();
			edges[i][2]=sc.nextInt();	
		}

		
		Arrays.sort(edges, (a,b)-> a[2]-b[2]);
		long ans = 0;
		int pick = 0;
		
		for(int i=0; i<E; i++) {

			int x = edges[i][0];
			int y = edges[i][1];
			int wei = edges[i][2];

			if(p[x]!=p[y]) {
				union(x,y);
				ans+=wei;
				pick++;
			}
			if(pick==V-1) {
				break;
			}
			
		}
		
		System.out.println(ans);
	}

	static String input = "6\r\n"
			+ "9\r\n"
			+ "1 2 5\r\n"
			+ "1 3 4\r\n"
			+ "2 3 2\r\n"
			+ "2 4 7\r\n"
			+ "3 4 6\r\n"
			+ "3 5 11\r\n"
			+ "4 5 3\r\n"
			+ "4 6 8\r\n"
			+ "5 6 8" + "";

//	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
//			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "\r\n";
}
