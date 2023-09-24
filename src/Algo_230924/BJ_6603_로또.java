package Algo_230924;
import java.util.ArrayList;
import java.util.Scanner;

public class BJ_6603_로또 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> list = new ArrayList<>();
        while(true) {
        	
        int M = sc.nextInt();
        if(M==0) {
        	break;
        }//if
        else {
        	int arr[] = new int[M];
        	for(int i=0; i<M; i++) {
        		arr[i] = sc.nextInt();
        	}
            StringBuilder result = new StringBuilder(); // StringBuilder 생성
            ArrayList<Integer> current = new ArrayList<>();
            dfs(arr, current, result);
            
            System.out.print(result.toString()); // 결과 출력
            System.out.println();

        }//else

        }//while 


    }
    
    public static void dfs(int[] arr,  ArrayList<Integer> current, StringBuilder result) {
        int n = arr.length;
    	if(current.size() == 6) {
            for(int a : current) {
            	result.append(a).append(' ');
            }
            result.append("\n"); // 줄 바꿈 추가
            return;
        }
        
        for(int i = 0; i < n; i++) {
        	if(shouldAdd(current, arr[i])){
            current.add(arr[i]);
            dfs(arr, current, result);
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

}
