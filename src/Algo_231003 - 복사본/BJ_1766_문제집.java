package Algo_231003;

import java.util.*;
import java.io.*;

public class BJ_1766_문제집 {
	static int N,E;
	static ArrayList<Integer>[] adjlist ; 
	static int[] degree;
	static class node{
		int y,w;

		public node(int y, int w) {
			this.y = y;
			this.w = w;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		N = sc.nextInt();
		E = sc.nextInt();
		degree = new int[N];
		adjlist = new ArrayList[N];
		for(int i=0; i<N ;i++) {
			adjlist[i]=new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			int a= sc.nextInt()-1;
			int b = sc.nextInt()-1;
			adjlist[a].add(b);
			degree[b]++;
		}
		
		toposort();
		
	}
	static void toposort() {
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0; i<N; i++){
			if(degree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.printf("%d ",cur+1);
			for(int a: adjlist[cur]) {
				degree[a]--;
				if(degree[a]==0) {
					q.add(a);
				}
			}
			
		}
		
	}
	
	static String input1 = "4 2\r\n"
			+ "4 2\r\n"
			+ "3 1";
}