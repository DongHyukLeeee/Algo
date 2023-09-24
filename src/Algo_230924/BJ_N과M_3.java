package Algo_230924;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_N과M_3 {
    static int M, N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        ArrayList<ArrayList<Integer>> current = new ArrayList<>();
        for (int msk = 0; msk < 1 << N; msk++) {
            if (Integer.bitCount(msk) == M) {
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    if ((msk & 1 << i) > 0) {
                        temp.add(arr[i]);
                    }
                }
                current.add(temp);
            }
        }

        // 사전식 순서로 정렬

        Collections.sort(current, (a,b) ->{
        	for(int i=0; i<M; i++) {
        		if(a.get(i)!=b.get(i)) {
        			return a.get(i)-b.get(i);
        		}
        	}
        	return 0;
        	
        });
//        Collections.sort(current, (a, b) -> {
//            for (int i = 0; i < M; i++) {
//                if (a.get(i) != b.get(i)) {
//                    return a.get(i) - b.get(i);
//                }
//            }
//            return 0;
//        });

        // 결과 출력
        for (ArrayList<Integer> permutation : current) {
            for (int a : permutation) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
