package Algo_230926;

import java.util.*;
import java.io.*;

public class BJ_9205_맥주마시면서_걸어가기{
	static int [] startPos ;
	static int [] finalPos ;
	static int[][] cvsPos ;
	static String res ="sad";
	static int cvsNum;
	
	static class Point {
		int x, y ;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int Tcase= sc.nextInt();
		
		for(int tc=1; tc<=Tcase;  tc++) {
			cvsNum = sc.nextInt();
			startPos = new int [2];
			startPos[0] = sc.nextInt();
			startPos[1] = sc.nextInt();
			finalPos = new int [2];
			cvsPos = new int [cvsNum][2];
			res = "sad";
			for(int i=0; i<cvsNum ; i++) {
				cvsPos[i][0]=sc.nextInt();
				cvsPos[i][1]=sc.nextInt();
			}
			finalPos[0] = sc.nextInt();
			finalPos[1] = sc.nextInt();
			
			
		bfs();
		

		System.out.println(res);
		}//Tcase;
		
	}
		
		public static void bfs() {
			
			Queue<Point> q =  new LinkedList<>();			
			q.add(new Point(startPos[0],startPos[1]));
			boolean visited[]= new boolean [cvsNum];
			
			
			while(!q.isEmpty()) {
				Point cur = q.poll();
				int curx = cur.x;
				int cury = cur.y;
				
				if(Math.abs(curx-finalPos[0])+Math.abs(cury-finalPos[1])<=1000) {
					res = "happy";
					return;
				}
				for(int i=0; i<cvsNum; i++) {
					if(!visited[i]&&Math.abs(curx-cvsPos[i][0])+Math.abs(cury-cvsPos[i][1])<=1000) {
						q.add(new Point(cvsPos[i][0],cvsPos[i][1]));
						visited[i]=true;
						
					}
				}
				
			}
			
			
		}
		

	
	
	static String input = "2\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"1000 1000\r\n" + 
			"2000 1000\r\n" + 
			"2\r\n" + 
			"0 0\r\n" + 
			"1000 0\r\n" + 
			"2000 1000\r\n" + 
			"2000 2000" ;
			
	
}