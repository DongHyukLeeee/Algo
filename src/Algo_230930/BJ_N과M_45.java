package Algo_230930;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class BJ_N과M_45 {
    static int M, N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(input2);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int [N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder result = new StringBuilder(); // StringBuilder 생성
        ArrayList<Integer> current = new ArrayList<>();
        dfs(current, result);
        
        System.out.print(result.toString()); // 결과 출력
    }
    
    public static void dfs(ArrayList<Integer> current, StringBuilder result) {
        if(current.size() == M) {
            for(int a : current) {
            	result.append(a).append(' ');
            }
            result.append("\n"); // 줄 바꿈 추가
            return;
        }
        
        for(int i = 0; i < N; i++) {
        	if(shouldAdd(current, arr[i])){
            current.add(arr[i]);
            dfs(current, result);
            current.remove(current.size() - 1);
        	}
        }
    }
    public static boolean shouldAdd(ArrayList<Integer> list, int a) {
    	for(int i=0; i<list.size(); i++) {
    		if(list.get(i)>=a) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    static String input1 ="3 1\r\n"
    		+ "4 5 2";
    static String input2 ="4 2\r\n"
    		+ "9 7 9 1";
}
