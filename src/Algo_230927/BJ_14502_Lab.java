package Algo_230927;

import java.util.*;
import java.io.*;

public class BJ_14502_Lab {
    static int[][] map;
    static int N, M;
    static ArrayList<int[]> indList;
    static ArrayList<int[]> indList2;
    static int di[] = { -1, 1, 0, 0 };
    static int dj[] = { 0, 0, 1, -1 };

    static class point {
        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(input3);
        N = scanner.nextInt();
        M = scanner.nextInt();
        map = new int[N][M];
        indList = new ArrayList<>();
        indList2 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 0) {
                    int temp[] = new int[2];
                    temp[0] = i;
                    temp[1] = j;
                    indList.add(temp);
                }
            }
        }

        for (int i = 0; i < indList.size(); i++) {
            for (int j = i + 1; j < indList.size(); j++) {
                for (int k = j + 1; k < indList.size(); k++) {
                    int temp[] = new int[3];
                    temp[0] = i;
                    temp[1] = j;
                    temp[2] = k;
                    indList2.add(temp);
                }
            }
        }

        int maxCnt = 0;
        for (int l = 0; l < indList2.size(); l++) {
            int[][] mapCopy = deepCopy(map);
            
            int cnt = 0;
            mapCopy[indList.get(indList2.get(l)[0])[0]][indList.get(indList2.get(l)[0])[1]] = 1;
            mapCopy[indList.get(indList2.get(l)[1])[0]][indList.get(indList2.get(l)[1])[1]] = 1;
            mapCopy[indList.get(indList2.get(l)[2])[0]][indList.get(indList2.get(l)[2])[1]] = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (mapCopy[i][j] == 2) {
                        virusSpread(i, j, mapCopy);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (mapCopy[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        System.out.println(maxCnt);
    }

    public static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }

    public static void virusSpread(int start1, int start2, int[][] mapCopy) {
        boolean visited[][] = new boolean[N][M];
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(start1, start2));
        visited[start1][start2] = true;

        while (!queue.isEmpty()) {
            point cur = queue.poll();

            int curx = cur.x;
            int cury = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = curx + di[i];
                int ny = cury + dj[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (!visited[nx][ny] && mapCopy[nx][ny] == 0) {
                    mapCopy[nx][ny] = 2;
                    queue.add(new point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

	static String input1 = "7 7\r\n" + "2 0 0 0 1 1 0\r\n" + "0 0 1 0 1 2 0\r\n" + "0 1 1 0 1 0 0\r\n"
			+ "0 1 0 0 0 0 0\r\n" + "0 0 0 0 0 1 1\r\n" + "0 1 0 0 0 0 0\r\n" + "0 1 0 0 0 0 0";
	
	static String input2 = "4 6\r\n" + 
			"0 0 0 0 0 0\r\n" + 
			"1 0 0 0 0 2\r\n" + 
			"1 1 1 0 0 2\r\n" + 
			"0 0 0 0 0 2";
	static String input3 = "8 8\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"2 0 0 0 0 0 0 2\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0";
}