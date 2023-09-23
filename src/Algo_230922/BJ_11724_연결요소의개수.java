package Algo_230922;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class BJ_11724_연결요소의개수 {
		static int P[];
	
	public static int findset(int x) {
		if(x!=P[x]) {
			P[x]=findset(P[x]);
		}
		return P[x];
	}	
	public static void union(int x, int y) {
		if(x>y) {
			P[findset(y)]=P[findset(x)];
		}
		else {
			P[findset(x)]=P[findset(y)];
		}
		
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int numNodes = sc.nextInt();
		int numEdges = sc.nextInt();
		P = new int[numNodes+1];
		for(int i=1; i<numNodes+1; i++) {
			P[i]=i;
		}

		int [][] Edges = new int [numEdges][2];
		for(int i=0;i<numEdges; i++ ) {
			Edges[i][0]=sc.nextInt();
			Edges[i][1]=sc.nextInt();
			union(Edges[i][0],Edges[i][1]);
		}
		for(int i=0; i<numNodes; i++){
			findset(i);
		}
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0; i<=numNodes; i++) {
			if(findset(i)!=0) {
				hs.add(P[i]);
			}
		}
		
		System.out.println(Arrays.toString(P));
		System.out.println(hs.size());
	}
	
	static String input = "6 8\r\n"
			+ "1 2\r\n"
			+ "2 5\r\n"
			+ "5 1\r\n"
			+ "3 4\r\n"
			+ "4 6\r\n"
			+ "5 4\r\n"
			+ "2 4\r\n"
			+ "2 3";
}