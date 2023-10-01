package Algo_230929;

import java.util.*;
import java.io.*;

public class BJ_14167_Moocast  {
	static int[] p;
	
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
		Scanner sc = new Scanner(inputString);
		
		int N = sc.nextInt();
		int graph[][] = new int [N][2];
		for(int i=0; i<N; i++) {
			graph[i][0]=sc.nextInt();
			graph[i][1]=sc.nextInt();
		}
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i]=i;
		}
		int distance[][] = new int[N*(N-1)/2][3];
		int k=0; 
		for(int i=0; i<N ;i++) {
			for(int j=i+1; j<N; j++) {
				int a = graph[i][0];
				int b = graph[i][1];
				int c = graph[j][0];
				int d = graph[j][1];
				distance[k][0]=(a-c)*(a-c)+(b-d)*(b-d);
				distance[k][1]=i;
				distance[k][2]=j;
				k++;
			}
		}
		Arrays.sort(distance, (a,b)-> (a[0]-b[0]));
		int res=0;
		int cnt=0;
		for(int i=0; i<N*(N-1)/2;i++) {
			int a = distance[i][0];
			int b = distance[i][1];
			int c = distance[i][2];
			if(find(b)!=find(c)) {
				union(b, c);
                res = Math.max(res, a); // Update the maximum energy required
			}
			if(cnt==N-1) break;
			
		
			
		}
		
		System.out.println(res);
		

	}
	static String inputString = "4\r\n"
			+ "1 3\r\n"
			+ "5 4\r\n"
			+ "7 2\r\n"
			+ "6 1";
}