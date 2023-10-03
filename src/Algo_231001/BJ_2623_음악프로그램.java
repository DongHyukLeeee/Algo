package Algo_231001;

import java.util.*;


import java.io.*;

public class BJ_2623_음악프로그램 {
	
	static int v, e;
	static ArrayList<Integer>[] adjlist;
	static int degree[];
	static ArrayList<Integer> answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(inputString);
		
		v= sc.nextInt();
		e= sc.nextInt();
		degree = new int[v+1];
		adjlist = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			adjlist[i]=new ArrayList<>();
		}
		for(int i=1; i<=e; i++) {
			int a =sc.nextInt();
			int temp [] = new int [a];
			for(int j=0; j<a; j++) {
				int b= sc.nextInt();
				temp[j]=b;
			}
			for(int j=0; j<a-1;j++) {
				adjlist[temp[j]].add(temp[j+1]);
				degree[temp[j+1]]++;
			}
		}
		answer = new ArrayList<>();
		topologicalsort();

		if(answer.size()==v) {
			for(int a : answer) {
				System.out.println(a);
			}
		}
		else {
			System.out.println(0);
		}
		

		
	}
	
	static void topologicalsort() {
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=v; i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();

			answer.add(cur);
			for(int next: adjlist[cur]) {
				degree[next]--;
				if(degree[next]==0) {
					q.add(next);
				}
			}
			
		}
		
	}

	static String inputString = "6 3\r\n"
			+ "3 1 4 3\r\n"
			+ "4 6 2 5 4\r\n"
			+ "2 2 3";
}