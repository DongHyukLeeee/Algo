package Algo_230925;

import java.util.*;
import java.io.*;

public class BJ_14567_선수과목 {
    static int V, E;
    static int[] Degree;
    static int[] Result;
    static ArrayList<Integer>[] Semester;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input);

        V = sc.nextInt();
        E = sc.nextInt();
        Degree = new int[V];
        Result = new int[V];
        Semester = new ArrayList[V];
        
        for (int i = 0; i < V; i++) {
            Semester[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            Degree[b]++;
            Semester[a].add(b);
        }
        
        find();
        
        for (int a : Result) {
            System.out.printf("%d ", a);
        }
    }

    static void find() {
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < V; i++) {
            if (Degree[i] == 0) {
                q.add(i);
                Result[i] = 1; // Initialize courses with no prerequisites to 1 semester
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i=0; i<Semester[cur].size(); i++) {
            	int temp = Semester[cur].get(i);
            	Degree[temp]--;
            	if(Degree[temp]==0)
            	{
            		q.add(temp);
            		Result[temp]=Result[cur]+1;
            	}
            }
        }
    }


	
	static String input = "6 4\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2 5\r\n"
			+ "4 5";
}