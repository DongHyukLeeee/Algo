package Algo_231001;

import java.util.*;
import java.awt.Image;
import java.io.*;
import java.nio.channels.Channels;

public class BJ_14890_경사로 {
	static int [][] map;
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(input3);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(check(map[i])) {
				cnt++;
			}

		}
		
		for(int j=0; j<N; j++) {
			int temp[] = new int[N];
			for(int i=0; i<N ;i++) {
				temp[i] = map[i][j];
			}
			if(check(temp)) {
				cnt++;
			}

		}
		System.out.println(cnt);
	}
		
	static boolean check(int arr[]) {
	    boolean[] visited = new boolean[N]; // visited 배열 초기화
	    
	    for (int i = 0; i < N - 1; i++) {
	        int diff = arr[i] - arr[i + 1];
	        
	        // 높이 차이가 1 이상인 경우는 경사로를 설치할 수 없음
	        if (Math.abs(diff) > 1) {
	            return false;
	        }
	        
	        // 높이가 높아지는 경우 (오르막길)
	        if (diff == -1) {
	            if (i - M + 1 >= 0) {
	                // 경사로 설치 가능한 범위 내에서
	                for (int j = i; j >= i - M + 1; j--) {
	                    if (visited[j] || arr[j] != arr[i]) {
	                        return false; // 겹치는 부분이거나 높이가 다르면 설치 불가
	                    }
	                    visited[j] = true; // 경사로 설치
	                }
	            } else {
	                return false; // 경사로 설치 범위를 벗어나면 설치 불가
	            }
	        }
	        
	        // 높이가 낮아지는 경우 (내리막길)
	        if (diff == 1) {
	            if (i + 1 + M <= N) {
	                // 경사로 설치 가능한 범위 내에서
	                for (int j = i + 1; j < i + 1 + M; j++) {
	                    if (visited[j] || arr[j] != arr[i + 1]) {
	                        return false; // 겹치는 부분이거나 높이가 다르면 설치 불가
	                    }
	                    visited[j] = true; // 경사로 설치
	                }
	                i = i + M - 1; // 다음 비교할 인덱스로 이동
	            } else {
	                return false; // 경사로 설치 범위를 벗어나면 설치 불가
	            }
	        }
	    }
	    return true;
	}



	static String input1 = "6 2\r\n"
			+ "3 3 3 3 3 3\r\n"
			+ "2 3 3 3 3 3\r\n"
			+ "2 2 2 3 2 3\r\n"
			+ "1 1 1 2 2 2\r\n"
			+ "1 1 1 3 3 1\r\n"
			+ "1 1 2 3 3 2";
	static String input2 = "6 2\r\n"
			+ "3 2 1 1 2 3\r\n"
			+ "3 2 2 1 2 3\r\n"
			+ "3 2 2 2 3 3\r\n"
			+ "3 3 3 3 3 3\r\n"
			+ "3 3 3 3 2 2\r\n"
			+ "3 3 3 3 2 2";
	static String input3 = "6 3\r\n"
			+ "3 2 1 1 2 3\r\n"
			+ "3 2 2 1 2 3\r\n"
			+ "3 2 2 2 3 3\r\n"
			+ "3 3 3 3 3 3\r\n"
			+ "3 3 3 3 2 2\r\n"
			+ "3 3 3 3 2 2";
}