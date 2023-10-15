package Algo_231008;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class test2 {
	
	static int limit, N, M;
	static int[][]map;
	
	static int di[] = {-1,1,0,0   ,1,2,2,1,    -1,-2,-2,-1};
	static int dj[] = {0,0,-1,1   ,2,1,-1,-2  , -2,-1,1,2};

	static class point {
		
		int x,y,cnt,used;

		point(int x, int y, int cnt, int used) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.used = used;
		}
		
		
	}
 	public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		
 		 limit = sc.nextInt();
 		 M = sc.nextInt();
 		 N = sc.nextInt();
 		 
 		 map = new int[N][M];
 		 
 		for(int i=0; i<N; i++) {
 			String temp = sc.next();
 			for(int j=0; j<M; j++) {
 				map[i][j]=temp.charAt(j);
 			}
 		}
 		
 		int res = bfs();
 		System.out.println(res);

 		
 		
 	}
 	
 	 static int bfs() {
         Queue<point> q = new LinkedList<>();
         boolean visited[][][] = new boolean[limit + 1][N][M];
         q.add(new point(0, 0, 0, 0));
         visited[0][0][0] = true;

         while (!q.isEmpty()) {
             point cur = q.poll();
             int curx = cur.x;
             int cury = cur.y;
             int curcnt = cur.cnt;
             int curused = cur.used;

             if (curused > limit) continue;

             if (curx == N - 1 && cury == M - 1 && curused <= limit) {
                 return curcnt;
             }

             for (int i = 0; i < 12; i++) {
                 int ni = curx + di[i];
                 int nj = cury + dj[i];

                 if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;

                 if (!visited[curused][ni][nj] && map[ni][nj] == 0) {
                     if (i <= 3) {
                         visited[curused][ni][nj] = true;
                         q.add(new point(ni, nj, curcnt + 1, curused));
                     } else {
                         if (curused <= limit - 1) {
                             visited[curused + 1][ni][nj] = true;
                             q.add(new point(ni, nj, curcnt + 1, curused + 1));
                         }
                         else continue;
                     }
                 }
             }
         }

         return -1;
     }
}