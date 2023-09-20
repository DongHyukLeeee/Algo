package Algo_230920;

import java.util.*;

public class BJ_1759_암호만들기2 {
	static int[] p;
	
	static int findset(int x) {
		if(x!=p[x]) {
			p[x] = findset(p[x]);
		}
		return p[x];
	}
	static void union(int x, int y) {
		p[findset(y)]=findset(x);
	}
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(input);
	
	
	int M = sc.nextInt();
	int N = sc.nextInt();
	for(int i=1; i<N+1; i++) {
		p[i]=i;
	}
	int edges[][] = new int [N][3];
	
	for(int i=0; i<N ;i++) {
		edges[i][0]=sc.nextInt();
		edges[i][1]=sc.nextInt();
		edges[i][2]=sc.nextInt();
	}
	int firstStation = sc.nextInt();
	int lastStation = sc.nextInt();
	
	Arrays.sort(edges, new Comparator<int []>() {
		@Override
		public int compare(int [] o1, int [] o2) {
			return o1[2]-o2[2];
		}
	});
	
	
	
	
	}
	
	static String input = "5\r\n"
			+ "8\r\n"
			+ "1 2 2\r\n"
			+ "1 3 3\r\n"
			+ "1 4 1\r\n"
			+ "1 5 10\r\n"
			+ "2 4 2\r\n"
			+ "3 4 1\r\n"
			+ "3 5 1\r\n"
			+ "4 5 3\r\n"
			+ "1 5";
}