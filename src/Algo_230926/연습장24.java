package Algo_230926;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 연습장24 {
    static int V, E;
    static int[] Degree;
    static int[] Result;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Integer> check;
    static int min = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();
        Degree = new int[V];
        Result = new int[V];
        adjList = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            Degree[b]++;
            adjList[a].add(b);
        }
        check = new ArrayList<>();
        check.add(0);
        check.add(1);
        check.add(3);
        int[] arr = {1,2,3,4,5};
        divideTown(0,arr,check,check);
    }

    public static void divideTown(int index, int arr[], ArrayList<Integer> town1, ArrayList<Integer> town2) {
    	if(index==V) {
    		
    		return;
    	}
    		
    		divideTown(index+1,arr,town1,town2);
    		divideTown(index+1,arr,town1,town2);
    		
    	

    }
    public static boolean isa5djacant(ArrayList<Integer> check) {
    	boolean visit[] = new boolean[V];
    	Arrays.fill(visit, false);
    	Queue <Integer> queue = new LinkedList<Integer>();
    	queue.add(check.get(0));
    	visit[check.get(0)] = true;
    	
    	while(!queue.isEmpty()) {
    		int cur = queue.poll();
    		
    		for(int i=0; i<adjList[cur].size();i++) {
    			int next = adjList[cur].get(i);
    			if(!visit[next]) {
    			visit[next]=true;
    			queue.add(next);
    			}
    			
    		}
    		
    	}
    	for(int i=0; i<check.size();i++) {
    		if(visit[check.get(i)]==false) {
    			return false;
    		}
    	}
    	
    	
    	return true;

    }
	static String input = "6 4\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2 5\r\n"
			+ "4 5";
}