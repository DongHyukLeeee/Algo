package Algo_231024;

import java.util.*;

import java.io.*;

public class BJ_2580_스도쿠 {
	static final int N =9;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(input1);
		map= new int[N][N];
		System.out.println(whereiszoneforiandj(0,2)); 
	}
	
	static void fill(int currenti, int currentj) {
		
		
	}
	
	static int whereiszoneforiandj(int currenti, int currentj) {
		int zone[][] = new int[3][3];
		int temp=1;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				zone[i][j]=temp;
				temp++;
			}
		}
		int currentzone = zone[currenti/3][currentj/3];
		return currentzone;
	}
	
	static boolean isOkayinthatZone(int curi  ,int curj) {
		boolean isOk = true;
		int curzone = whereiszoneforiandj(curi, curj);
		int currentZonefori = (curzone+1)/3;
		int currentZoneforj = (curzone+1)%3;
		
		
		return isOk;
	}
	static String input1 = "0 3 5 4 6 9 2 7 8\r\n"
			+ "7 8 2 1 0 5 6 0 9\r\n"
			+ "0 6 0 2 7 8 1 3 5\r\n"
			+ "3 2 1 0 4 6 8 9 7\r\n"
			+ "8 0 4 9 1 3 5 0 6\r\n"
			+ "5 9 6 8 2 0 4 1 3\r\n"
			+ "9 1 7 6 5 2 0 8 0\r\n"
			+ "6 0 3 7 0 1 9 5 2\r\n"
			+ "2 5 8 3 9 4 7 6 0";
}