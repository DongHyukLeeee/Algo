package Algo_230928;
import java.util.*;
import java.io.*;

public class 아기상어2_못품 {
    static int N, M;
    static int[][] map;
    static int[] di = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dj = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(input2);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        List<Point> sharks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    sharks.add(new Point(i, j));
                }
            }
        }

        int maxDistance = Integer.MIN_VALUE;

        for (Point shark : sharks) {
            int[][] distance = new int[N][M];
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], -1);
            }

            Queue<Point> queue = new LinkedList<>();
            queue.add(shark);
            distance[shark.x][shark.y] = 0;

            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                int x = cur.x;
                int y = cur.y;

                for (int d = 0; d < 8; d++) {
                    int ni = x + di[d];
                    int nj = y + dj[d];
                    if (ni >= 0 && ni < N && nj >= 0 && nj < M && distance[ni][nj] == -1) {
                        distance[ni][nj] = distance[x][y] + 1;
                        queue.add(new Point(ni, nj));
                        maxDistance = Math.max(maxDistance, distance[ni][nj]);
                    }
                }
            }
        }

        System.out.println(maxDistance);
    }



	static String input = "5 4\r\n" + "0 0 1 0\r\n" + "0 0 0 0\r\n" + "1 0 0 0\r\n" + "0 0 0 0\r\n" + "0 0 0 1";
	static String input2 = "7 4\r\n" + "0 0 0 1\r\n" + "0 1 0 0\r\n" + "0 0 0 0\r\n" + "0 0 0 1\r\n" + "0 0 0 0\r\n"
			+ "0 1 0 0\r\n" + "0 0 0 1";
}