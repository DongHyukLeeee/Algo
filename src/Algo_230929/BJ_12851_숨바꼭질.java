package Algo_230929;

import java.util.*;
import java.io.*;

public class BJ_12851_숨바꼭질 {
	
	static int cnt;
	static int start, finish;
	
	public static void main(String[] args) {
		
		start = 5;
		finish =17;
		
		System.out.println(bfs());
		System.out.println(cnt);
		

	}
	
	static int bfs() {
		int aa = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size;i++) {
			int cur = q.poll();
			if(cur==finish) {
				cnt++;
			}
			else {
				if(cur-1>=0) {
					q.add(cur-1);
				}
				if(cur+1<=100000) {
					q.add(cur+1);
				}
				if(cur*2<=100000) {
					q.add(cur*2);
				}
			}
				
				
			}
			aa++;
			
		}
				
				
		
		return aa;
	}
}