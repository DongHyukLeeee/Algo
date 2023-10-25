package Algo_231024;

import java.util.*;

import java.io.*;

public class BJ_2580_스도쿠 {
	static final int N =9;
	static int[][] map;
	static final int compare[] = {1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		Scanner sc = new Scanner(input2);
		map= new int[N][N];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(map[i][j]==0) {
					fill(i,j);				}
			}
		}
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.printf("%d", map[i][j]);
				}
			System.out.println();
			}
		
}	
	

	
	static void fill(int currenti, int currentj) {
		
		
			for(int i=1; i<=9; i++) {
				map[currenti][currentj]=i;
				if(isOkayinthatZone(currenti, currentj)) {
					return;
				}
			}
			
		
		
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
		int garocheck[] = new int[9];
		int serocheck[] = new int[9];


		for(int j=0; j<9; j++) {
			garocheck[j]=map[curi][j];
		}
		for(int j=0; j<9; j++) {
			serocheck[j]=map[j][curj];
		}
		Arrays.sort(garocheck);
		Arrays.sort(serocheck);
		
		
		int curzone = whereiszoneforiandj(curi, curj);
		int currentZonefori = (curzone-1)/3; //0~2
		int currentZoneforj = (curzone-1)%3; //0~2
		int starti = currentZonefori*3;
		int startj = currentZoneforj*3;
		int temp [] = new int [9];
		int a = 0;
		for(int i =starti; i<starti+3; i++) {
			for(int j =startj; j<startj+3; j++) {
				temp[a]=map[i][j];
				a++;
			}
		}
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		for(int i=0; i<9; i++) {
			if(compare[i]!=temp[i]) {
				return false;
			}
			if(garocheck[i]!=compare[i]) {
				return false;
			}
			if(serocheck[i]!=compare[i]) {
				return false;
			}
		}
		
		return true;
	}
	static String input1 = 
			"0 3 5 4 6 9 2 7 8\r\n"
			+ "7 8 2 1 0 5 6 0 9\r\n"
			+ "0 6 0 2 7 8 1 3 5\r\n"
			+ "3 2 1 0 4 6 8 9 7\r\n"
			+ "8 0 4 9 1 3 5 0 6\r\n"
			+ "5 9 6 8 2 0 4 1 3\r\n"
			+ "9 1 7 6 5 2 0 8 0\r\n"
			+ "6 0 3 7 0 1 9 5 2\r\n"
			+ "2 5 8 3 9 4 7 6 0";
	static String input2 = 
					  "1 3 5 4 6 9 2 7 8\r\n"
					+ "7 8 2 1 0 5 6 0 9\r\n"
					+ "9 6 4 2 7 8 1 3 5\r\n"//4넣기
					+ "3 2 1 0 4 6 8 9 7\r\n"
					+ "8 0 4 9 1 3 5 0 6\r\n"
					+ "5 9 6 8 2 0 4 1 3\r\n"
					+ "9 1 7 6 5 2 0 8 0\r\n"
					+ "6 0 3 7 0 1 9 5 2\r\n"
					+ "2 5 8 3 9 4 7 6 0";
}