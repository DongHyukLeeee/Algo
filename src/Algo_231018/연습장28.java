package Algo_231018;

import java.util.*;
import java.io.*;

public class 연습장28 {

	static int N;
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);

		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {

			arr[i] = sc.nextInt();

		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		int cnt=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur>N-1) continue;
			int curNum = arr[cur];
			
			if(cur==N-1) {
				return cnt;
			}
			if (curNum==0) continue;
			for(int i=1; i<=N-1&&i<=curNum; i++) {
				q.add(cur+i);
				cnt++;
			}
			
			
			
		}
		return -1;
			
		
	}

	static String input1 = "10\r\n" + "1 2 0 1 3 2 1 5 4 2";
}