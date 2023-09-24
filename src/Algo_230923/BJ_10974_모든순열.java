package Algo_230923;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_10974_모든순열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 초기 순열 생성
        ArrayList<Integer> permutation = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            permutation.add(i);
        }

        // 다음 순열이 존재하는 동안 반복
        do {
            for (int num : permutation) {
                System.out.print(num + " ");
            }
            System.out.println();
        } while (nextPermutation(permutation));
    }

    // 다음 순열을 생성하는 함수
    public static boolean nextPermutation(ArrayList<Integer> arr) {
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) >= arr.get(i + 1)) {
            i--;
        }
        if (i < 0) {
            return false; // 다음 순열이 없음
        }

        int j = arr.size() - 1;
        while (arr.get(i) >= arr.get(j)) {
            j--;
        }

        // i와 j 위치의 원소 교환
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);

        // i 이후의 원소들을 오름차순으로 정렬
        int left = i + 1;
        int right = arr.size() - 1;
        while (left < right) {
            temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }

        return true;
    }
}
