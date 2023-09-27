package Algo_230927;

import java.util.*;
import java.io.*;

public class BJ_7576_2차원토마토 {
    static int N, M;
    static int[][] tmap;
    static int di[] = {-1, 1, 0, 0};
    static int dj[] = {0, 0, -1, 1};

    static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(input4);
        M = sc.nextInt();
        N = sc.nextInt();
        tmap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmap[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(ripenTomato());
    }

    static int ripenTomato() {
        Queue<point> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmap[i][j] == 1) {
                    q.add(new point(i, j));
                }
            }
        }

        int day = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                point cur = q.poll();
                int curi = cur.x;
                int curj = cur.y;

                for (int i = 0; i < 4; i++) {
                    int ni = curi + di[i];
                    int nj = curj + dj[i];
                    if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                    if (tmap[ni][nj] == 0) {
                        tmap[ni][nj] = 1;
                        q.add(new point(ni, nj));
                    }
                }
            }
            if (!q.isEmpty()) day++;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmap[i][j] == 0) {
                    return -1;
                }
            }
        }
        
        return day;
    }


	static String input1 = "6 4\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 1";//8
	static String input2 = "6 4\r\n" + 
			"0 -1 0 0 0 0\r\n" + 
			"-1 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 1";//-1
	static String input3 = "6 4\r\n" + 
			"1 -1 0 0 0 0\r\n" + 
			"0 -1 0 0 0 0\r\n" + 
			"0 0 0 0 -1 0\r\n" + 
			"0 0 0 0 -1 1";//6
	static String input4 = "5 5\r\n" + 
			"-1 1 0 0 0\r\n" + 
			"0 -1 -1 -1 0\r\n" + 
			"0 -1 -1 -1 0\r\n" + 
			"0 -1 -1 -1 0\r\n" + 
			"0 0 0 0 0";//14
}