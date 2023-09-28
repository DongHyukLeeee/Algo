package Algo_230928;

import java.util.*;


import java.io.*;

public class BJ_14950_정복자 {
	
	static int p[] ; 
	static int V,E,t ; 
	
    static int set(int x) {
        if (x != p[x]) {
            p[x] = set(p[x]);
        }
        return p[x];
    }

	public static void union(int a , int b) {
		if(a<b) {
		p[set(b)] = p[set(a)];
		}
		else {
			p[set(a)] = p[set(b)];
		}
	}
	
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(inputString2);
	
	V= sc.nextInt();
	E= sc.nextInt();
	t =sc.nextInt();
	
	p = new int[V+1];
	for(int i=1; i<V+1; i++) {
		p[i]=i;
	}
	int Edges [][] = new int [E][3];
	for(int i=0; i<E ;i++) {
		Edges[i][0]=sc.nextInt();
		Edges[i][1]=sc.nextInt();
		Edges[i][2]=sc.nextInt();
	}
	Arrays.sort(Edges, (a,b)-> a[2]-b[2]);
	
	int cnt =0;
	int res =0;
	
	for(int i=0; i<E; i++) {
		int a = Edges[i][0];
		int b = Edges[i][1];
		int c = Edges[i][2];

		if(set(a)!=set(b)) {
			union(a,b);

			res+=c+(t)*cnt;
			cnt++;
		}
		if(cnt == V-1) {
			break;
		}
		
	}

	
	System.out.println(res);
	}
	static String inputString = "2 1 10\r\n"
			+ "1 2 3";
	static String inputString2 = "4 5 8\r\n"
			+ "1 2 3\r\n"
			+ "1 3 2\r\n"
			+ "2 3 2\r\n"
			+ "2 4 4\r\n"
			+ "3 4 1";
}