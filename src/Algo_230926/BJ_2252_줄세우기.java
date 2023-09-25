package Algo_230926;

import java.util.*;
import java.io.*;

public class BJ_2252_줄세우기 {
	static int V,E;
	static ArrayList Res;
	static ArrayList<Integer>[] adjList;
	static int[] degree;
	//변수들 선언
	public static void main(String[] args) {
	Scanner sc= new Scanner(input);	
	Res = new ArrayList<Integer>();
	
	V = sc.nextInt();
	E = sc.nextInt();
	
	adjList = new ArrayList[V];
	for(int i=0; i<V; i++) {
		adjList[i] = new ArrayList<>();
	}
	degree= new int[V];
	for(int i=0; i<E; i++) {
		int a = sc.nextInt()-1;
		int b= sc.nextInt()-1;
		
		adjList[a].add(b);
		degree[b]++;
	}
	
	sort();
	for(int i=0; i<Res.size(); i++) {
		System.out.printf("%d ", Res.get(i));

	}
	//메인
	}
	
	public static void sort() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<V; i++) {
			if(degree[i]==0) {
				q.add(i);
				Res.add(i+1);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<adjList[cur].size(); i++) {
				int temp = adjList[cur].get(i);
				degree[temp]--;
				if(degree[temp]==0) {
					q.add(temp);
					Res.add(temp+1);
				}
			}
		}
	//method	
	}
	
	
	static String input = "3 2\r\n"
			+ "1 3\r\n"
			+ "2 3";
	
}