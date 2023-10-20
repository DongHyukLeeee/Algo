package Algo_231020;

import java.util.*;

import java.io.*;

public class BJ_14426_접두사찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] aa = new String[N];
		String[] bb = new String[M];
		for (int i = 0; i < N; i++) {
			aa[i] = sc.next();
		}
		Arrays.sort(aa);

		for (int i = 0; i < M; i++) {
			bb[i] = sc.next();
		}
		char first_char[] = new char[N];
		for (int i = 0; i < N; i++) {
			first_char[i] = aa[i].charAt(0);
		}
		int cnt = 0;
		for (int i = 5
				; i < M; i++) {
			int idx = Arrays.binarySearch(first_char, bb[i].charAt(0)) ;
			if(idx<0) continue;
			char temp[] = Arrays.copyOf(first_char, N);
			
			while(true) {
				boolean flag = true;
				Arrays.sort(temp);
				idx=Arrays.binarySearch(temp, bb[i].charAt(0));
	
				
				if(idx<0) { break;}
				for(int j=0; j<bb[i].length(); j++) {
					if(bb[i].charAt(j)!=aa[idx].charAt(j)) {
						flag = false;
					}
				}
				temp[idx]='0';
//				System.out.println(i +"idx="+idx+ Arrays.toString(temp));
				if(flag) { cnt++;
				System.out.println("i is " + i);}
			}
			

		}
		System.out.println(cnt);
//		System.out.println(Arrays.toString(aa));
	}

	static String input1 = "5 10\r\n" + "baekjoononlinejudge\r\n" + "startlink\r\n" + "codeplus\r\n"
			+ "sundaycoding\r\n" + "codingsh\r\n" + "baekjoon\r\n" + "star\r\n" + "start\r\n" + "code\r\n"
			+ "sunday\r\n" + "coding\r\n" + "cod\r\n" + "online\r\n" + "judge\r\n" + "plus";

}
