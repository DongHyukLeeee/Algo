package Algo_230917;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class BJ_1158_요세푸스 {


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        
        

		int N =sc.nextInt();
        int K =sc.nextInt();
         ArrayList<Integer> list_ = new ArrayList<>();
         ArrayList<Integer> list = new ArrayList<>();

		int arr[] = new int [N];
		for(int i=0; i<N; i++) {
			list_.add(i+1);
		}
	
		for(int i=0; i<N; i++) {
			list.add(list_.get((K*(i+1)-1)%N));
			list_.remove((K*(i+1)-1)%N);
		}
		System.out.println(list);
		
	}
}
