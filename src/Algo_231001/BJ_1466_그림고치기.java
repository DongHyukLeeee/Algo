package Algo_231001;

import java.util.*;
import java.io.*;

public class BJ_1466_그림고치기	 {
	static int N,M;
	static char map [][];
	
	static class point{
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 map = new char[N][M];
		 
		 for(int i=0;i<N; i++) {
			 String temp = sc.next();
			 for(int j=0;j<M;j++) {
				 map[i][j]=temp.charAt(j);
			 }
		 }
		 for(int i=0;i<N; i++) {
			 for(int j=0;j<M;j++) {
				 if(map[i][j]=='.') {
					 if(isOkayToTransfer(i, j)) {
						 map[i][j]='#';
					 }
				 }
			 }
		 }
		 for(int i=0;i<N; i++) {
			 for(int j=0;j<M;j++) {
				System.out.printf("%c" , map[i][j]);
			 }
			 System.out.println();
		 }
		


	}
	
	static void bfs() {

	}
	
	
	static boolean isOkayToTransfer(int x, int y) {
		
		boolean search1 = false;
		boolean search2 = false;
		boolean search3 = false;
		boolean search4 = false;
		
		for(int i=0; i<x ;i++) {
			if(map[i][y]=='#') 
				search1=true;
		}
		for(int i=x+1; i<N ;i++) {
			if(map[i][y]=='#') 
				search2=true;
		}
		if(search1&&search2) return true;
		
		for(int j=0; j<y ;j++) {
			if(map[x][j]=='#') 
				search3=true;
		}
		for(int j=y+1; j<M ;j++) {
			if(map[x][j]=='#') 
				search4=true;
		}

		if(search3&&search4) return true;
		
		
		return false;
		
	}
	static String input = "6 8\r\n"
			+ "###.####\r\n"
			+ "#.#.#..#\r\n"
			+ ".#...#.#\r\n"
			+ ".#####.#\r\n"
			+ "......#.\r\n"
			+ "########";
	
	static String input2 = "4 4\r\n"
			+ "....\r\n"
			+ ".##.\r\n"
			+ ".##.\r\n"
			+ "....";
	static String input3 = "5 5\r\n"
			+ ".....\r\n"
			+ ".###.\r\n"
			+ ".#.#.\r\n"
			+ ".###.\r\n"
			+ ".....";
}