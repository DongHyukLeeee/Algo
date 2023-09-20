package Algo_230920;

import java.util.*;

public class BJ_1976_여행가자 {
	static int [] p;
	
	public static int findset(int x) {
		if(x!=p[x]) {
			p[x]=findset(p[x]);
		}
		return p[x];
		
	}
	static void union(int x, int y) {
		p[findset(y)]=findset(x);
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		p = new int [M+1];
		for(int i=1; i<=M; i++) {
			p[i]=i;
		}
		int arr[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(arr[i][j]==1) {
					union(i+1,j+1);
				}
			}
		}
		for(int i=1; i<M+1; i++) {
			findset(i);
		}
		int travelPoint[] = new int [M];
		for(int i=0; i<M ;i++) {
			travelPoint[i] = sc.nextInt();
		}
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i=0; i<M; i++) {
			hash.add(p[travelPoint[i]]);
		}
		String res ="NO";
		if(hash.size()==1) {
			res = "YES";
		}
		
		System.out.println(res);

		
	}
}