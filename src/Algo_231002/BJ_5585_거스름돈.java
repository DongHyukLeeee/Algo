package Algo_231002;

import java.util.*;
import java.io.*;

public class BJ_5585_거스름돈 {
	static int money;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		money = 1000-N;
		int cnt = 0;
		int moneyTransfer [] = {500,100,50,10,5,1};
		for(int i=0;i<6;i++) {
			cnt+= fn(moneyTransfer[i]);
		}
		
		System.out.println(cnt);

	}
	static int fn(int divide) {
		int res = 0;
		if(money/divide>=1) {
			res+=money/divide;
			money = money % divide;
		}
		return res;
	}
}