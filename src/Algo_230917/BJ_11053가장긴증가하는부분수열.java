package Algo_230917;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BJ_11053가장긴증가하는부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];
        ArrayList<Integer>[] lis = new ArrayList[N];
        int maxLen = 0;
        int maxIdx = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            lis[i] = new ArrayList<>();
            lis[i].add(arr[i]);

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    lis[i] = new ArrayList<>(lis[j]);
                    lis[i].add(arr[i]);
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        System.out.println(maxLen);
        for (int num : lis[maxIdx]) {
            System.out.print(num + " ");
        }
    }
}