package Algo_230922;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_7569_토마토 {
    static int M, N, H;
    static int[][][] tomatoBox;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        tomatoBox = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    tomatoBox[h][n][m] = sc.nextInt();
                }
            }
        }

        int days = bfs();

        System.out.println(days);
    }

    public static int bfs() {
        Queue<Tomato> queue = new LinkedList<>();

        // 처음에 익어있는 토마토를 큐에 추가
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoBox[h][n][m] == 1) {
                        queue.offer(new Tomato(h, n, m, 0));
                    }
                }
            }
        }

        int days = 0;

        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            days = tomato.days;

            for (int i = 0; i < 6; i++) {
                int nh = tomato.h + dz[i];
                int nn = tomato.n + dx[i];
                int nm = tomato.m + dy[i];

                if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M && tomatoBox[nh][nn][nm] == 0) {
                    tomatoBox[nh][nn][nm] = 1;
                    queue.offer(new Tomato(nh, nn, nm, tomato.days + 1));
                }
            }
        }

        // 모든 토마토가 익었는지 확인
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoBox[h][n][m] == 0) {
                        return -1; // 익지 않은 토마토가 있다면 -1 반환
                    }
                }
            }
        }

        return days;
    }

    static class Tomato {
        int h, n, m, days;

        public Tomato(int h, int n, int m, int days) {
            this.h = h;
            this.n = n;
            this.m = m;
            this.days = days;
        }
    }
}
