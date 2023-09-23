package Algo_230922;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_우선순위큐_선물 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int N =sc.nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i=0; i<N ;i++) {
			int temp = sc.nextInt();
			if(temp==0) {
				if(!q.isEmpty()) {
					System.out.println(q.poll());
				}
				else {
					System.out.println("-1");
				}
			}
			else {
				for(int j=0; j<temp; j++) {
					q.add(sc.nextInt());
				}
				                          
			}
		}
		
	}

	static String input = "5\r\n"
			+ "0\r\n"
			+ "2 3 2\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0";
}