package Algo_230920;
import java.util.Arrays;

import java.util.Comparator;
import java.util.Scanner;

public class SW_3289_서로소_집합 {
	static int[] p;
	
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	int Tcase = sc.nextInt();
	
	for(int tc= 1; tc<=Tcase; tc++) {
	int N = sc.nextInt();
	int M = sc.nextInt();
	p = new int [N+1];
	int edges[][] = new int [M][3];
	
	for(int i=0; i<=N; i++) {
		p[i]=i;
	}
	for(int i=0; i<M;i++) {
		for(int j=0; j<3; j++) {
			edges[i][j]=sc.nextInt();
		}
	}
	String ans = "";
	for(int i=0; i<M; i++) {

		int x = edges[i][1];
		int y = edges[i][2];
		if(edges[i][0]==0) {
			if(findset(x)!=findset(y)) {
				union(x,y);
			}
		}
		else if(edges[i][0]==1) {
			if(findset(x)==findset(y)) {
				ans+="1";
			}
			else {
				ans+="0";
			}
		}
	}
	System.out.println("#" + tc + " " + ans);
	
	}
	
	}
	static void union(int x, int y) {
		p[findset(y)]=findset(x);
	}
	
	static int findset(int x) {
		if(x!=p[x]) {
			p[x]= findset(p[x]); 
		}
		return p[x];
	}
	
}