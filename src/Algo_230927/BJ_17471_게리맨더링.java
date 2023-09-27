package Algo_230927;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_17471_게리맨더링{
    static int V, E;
    static int[] Result;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Integer> check;
    static int Population [];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        Result = new int[V];
        adjList = new ArrayList[V];
        Population = new int[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i=0; i<V; i++) {
        	Population[i]=sc.nextInt();
        }
        for (int i = 0; i < V; i++) {
        	int arrNum = sc.nextInt();
        	for(int j=0; j<arrNum; j++) {
        		adjList[i].add(sc.nextInt()-1);
        	}
        }
        int min = Integer.MAX_VALUE;

        for(int msk=1; msk<(1<<V)-1; msk++) {
        	ArrayList<Integer> list1 = new ArrayList<>();
        	ArrayList<Integer> list2 = new ArrayList<>();
        	
        	for(int i=0; i<V; i++) {
        		if((msk&1<<i)>0) {
        			list1.add(i);
        		}
        		else {
        			list2.add(i);
        		}
        	}
        	if(isadjacant(list1)&&(isadjacant(list2))){
                int sum1 = 0;
                for(int j =0; j<list1.size();j++ ) {
                	sum1+=Population[list1.get(j)];
                }
                int sum2 = 0;
                for(int j =0; j<list2.size();j++ ) {
                	sum2+=Population[list2.get(j)];
                }
                min = Math.min(Math.abs(sum1-sum2), min);
        	}
        	
        }
        if(min==Integer.MAX_VALUE) {
        	min=-1;
        }
        System.out.println(min);
   }


    public static boolean isadjacant(ArrayList<Integer> check) {
        boolean visit[] = new boolean[V];
        Arrays.fill(visit, false);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(check.get(0));
        visit[check.get(0)] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < adjList[cur].size(); i++) {
                int next = adjList[cur].get(i);
                if (!visit[next]) {
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }

        for (int i = 0; i < check.size(); i++) {
            int index = check.get(i);
            if (!visit[index]) {
                return false;
            }
        }

        return true;
    }
	static String input = "6\r\n"
			+ "5 2 3 4 1 2\r\n"
			+ "2 2 4\r\n"
			+ "4 1 3 6 5\r\n"
			+ "2 4 2\r\n"
			+ "2 1 3\r\n"
			+ "1 2\r\n"
			+ "1 2";
	static String input2 = "6\r\n"
			+ "1 1 1 1 1 1\r\n"
			+ "2 2 4\r\n"
			+ "4 1 3 6 5\r\n"
			+ "2 4 2\r\n"
			+ "2 1 3\r\n"
			+ "1 2\r\n"
			+ "1 2";
	static String input3 = "6\r\n"
			+ "10 20 10 20 30 40\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0\r\n"
			+ "0";
	static String input4 = "6\r\n"
			+ "2 3 4 5 6 7\r\n"
			+ "2 2 3\r\n"
			+ "2 1 3\r\n"
			+ "2 1 2\r\n"
			+ "2 5 6\r\n"
			+ "2 4 6\r\n"
			+ "2 4 5";
	static String input5 = "4\r\n"
			+ "\r\n"
			+ "1 2 3 4\r\n"
			+ "\r\n"
			+ "1 2\r\n"
			+ "\r\n"
			+ "1 3\r\n"
			+ "\r\n"
			+ "1 1\r\n"
			+ "\r\n"
			+ "0";
	
	
	
}