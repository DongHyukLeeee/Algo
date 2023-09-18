package Algo_230917;

import java.io.*;
import java.util.*;

public class BJ_1025_제곱수찾기 {

	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
        
		int n = sc.nextInt();
		int res = -999999;
		int start=0;
		boolean notOver = true;
		while(list.size()<=n) {
			if(isDown(start))
			list.add(start);
			start++;
			if(start>987654321) {
				res=-1;
				notOver = false;
				break;
			}
		}
		if(notOver) {
			res=list.get(list.size()-1);
		}
		for(int i=0; i<987654322; i++) {
			if(isDown(i)) {
				list.add(i);
			}
		}
		

		System.out.println(list.get(n));
	}
	
	public static boolean isDown(int x) {
		String temp = "";
		while(x>0) {
			temp += x%10;
			x /= 10;
		}
		for(int i=0; i<temp.length()-1; i++) {
			if(temp.charAt(i)>=temp.charAt(i+1)) {
				return false;
			}
		}
		return true;
		
	}


}