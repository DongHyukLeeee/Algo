package Algo_231023;

import java.util.*;

import java.io.*;

public class _3회차월말평가_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);

		int Tcase = sc.nextInt();

		for(int tc=1 ;tc<=Tcase; tc++) {
		int raceHeight[] = new int[10];
		int upHillLimit[] = new int[5];
		int downHillLimit[] = new int[5];
		for (int i = 0; i < 10; i++) {
			raceHeight[i] = sc.nextInt();
		}

		for (int i = 0; i < 5; i++) {
			upHillLimit[i] = sc.nextInt();
			downHillLimit[i] = sc.nextInt();
		}
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			boolean flag = true;
			for (int j = 0; j < 9; j++) {
				int diff = raceHeight[j+1]-raceHeight[j];
				//오르막이라면 
				if(diff > 0) {
					if(diff>upHillLimit[i]) flag=false;
				}
				//내리막이라면 
				else if(diff < 0){
					if(-diff>downHillLimit[i]) flag=false;
				}
				
			}
			if(flag) cnt++;
		}
		
		
		System.out.println("#" + tc + " " + cnt);
		}
	}

	static String input1 = "2\r\n" + "0 20 50 70 50 60 40 50 30 0\r\n" + "30 20\r\n" + "60 40\r\n" + "50 30\r\n"
			+ "40 40\r\n" + "100 0\r\n" + "100 90 90 90 90 90 90 90 90 50\r\n" + "30 20\r\n" + "60 40\r\n" + "50 30\r\n"
			+ "40 40\r\n" + "100 0\r\n" + "";

}
