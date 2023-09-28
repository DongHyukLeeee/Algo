package Algo_230928;

import java.util.*;
import java.io.*;
import java.text.BreakIterator;

public class 숨바꼭질 {
	
	static int N,M;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(inputString);
		
		N = sc.nextInt();
	    M = sc.nextInt();
	    
	    System.out.println(bfs());
			

	}
	
	static int bfs() {
        boolean[] visit = new boolean[100001]; // Adjust the size of the array
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size(); // Store the current level size
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                if (cur == M)
                    return cnt;

                if (cur + 1 <= 100000 && !visit[cur + 1]) {
                    queue.add(cur + 1);
                    visit[cur + 1] = true;
                }
                if (cur - 1 >= 0 && !visit[cur - 1]) {
                    queue.add(cur - 1);
                    visit[cur - 1] = true;
                }
                if (cur * 2 <= 100000 && !visit[cur * 2]) {
                    queue.add(cur * 2);
                    visit[cur * 2] = true;
                }
            }
            cnt++; // Increment the count for each level
        }
        return -1; // If the destination is not reachable
    }
	
	static String inputString = "5 17";
}