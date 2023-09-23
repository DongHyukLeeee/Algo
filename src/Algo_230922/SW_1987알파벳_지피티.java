package Algo_230922;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SW_1987알파벳_지피티 {
    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static boolean[] alphabetVisited = new boolean[26]; // 알파벳 방문 여부를 저장하는 배열
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String row = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        int maxDistance = bfs(0, 0);
        System.out.println(maxDistance);
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startX, startY, 1 });
        visited[startX][startY] = true;
        alphabetVisited[board[startX][startY] - 'A'] = true; // 시작 알파벳 방문 표시
        int maxDistance = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 상하좌우로 이동
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]
                        && !alphabetVisited[board[nx][ny] - 'A']) {
                    queue.offer(new int[] { nx, ny, distance + 1 });
                    visited[nx][ny] = true;
                    alphabetVisited[board[nx][ny] - 'A'] = true; // 이동한 칸의 알파벳 방문 표시
                    maxDistance = Math.max(maxDistance, distance + 1);
                }
            }
        }

        return maxDistance;
    }
}
