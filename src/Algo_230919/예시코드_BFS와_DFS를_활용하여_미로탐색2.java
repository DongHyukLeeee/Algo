package Algo_230919;

import java.util.LinkedList;
import java.util.Queue;

public class 예시코드_BFS와_DFS를_활용하여_미로탐색2 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    // 이동할 수 있는 방향: 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        // 미로의 크기와 데이터 입력
        N = 4;
        M = 6;
        maze = new int[N][M];
        visited = new boolean[N][M];

        String[] input = {
            "101111",
            "101010",
            "101011",
            "111011"
        };

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maze[i][j] = input[i].charAt(j) - '0';
            }
        }

        // DFS로 최소 칸 수 구하기
        int dfsResult = dfs(0, 0, 1);

        // 방문 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        // BFS로 최소 칸 수 구하기
        int bfsResult = bfs(0, 0);

        System.out.println("DFS로 찾은 최소 칸 수: " + dfsResult);
        System.out.println("BFS로 찾은 최소 칸 수: " + bfsResult);
    }

    // DFS 구현
    static int dfs(int x, int y, int count) {
        if (x == N - 1 && y == M - 1) {
            return count;
        }

        visited[x][y] = true;

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && maze[nx][ny] == 1 && !visited[nx][ny]) {
                int result = dfs(nx, ny, count + 1);
                minCount = Math.min(minCount, result);
            }
        }

        visited[x][y] = false;
        return minCount;
    }

    // BFS 구현
    static int bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>(); // 큐를 사용하여 BFS를 구현
        queue.offer(new Point(startX, startY, 1)); // 시작 위치를 큐에 추가하고 칸 수 1로 초기화
        visited[startX][startY] = true; // 시작 위치를 방문했음을 표시

        while (!queue.isEmpty()) { // 큐가 비어있지 않은 동안 반복
            Point current = queue.poll(); // 큐에서 현재 위치를 가져옴
            int x = current.x; // 현재 위치의 x 좌표
            int y = current.y; // 현재 위치의 y 좌표
            int count = current.count; // 현재 위치까지의 칸 수

            if (x == N - 1 && y == M - 1) { // 목표 지점에 도달한 경우
                return count; // 현재까지의 칸 수를 반환
            }

            for (int i = 0; i < 4; i++) { // 상, 하, 좌, 우 네 방향에 대해서 검사
                int nx = x + dx[i]; // 다음 x 좌표
                int ny = y + dy[i]; // 다음 y 좌표

                if (isValid(nx, ny) && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    // 다음 위치가 유효하고, 길(1)이며, 방문하지 않은 경우
                    queue.offer(new Point(nx, ny, count + 1)); // 다음 위치를 큐에 추가하고 칸 수를 1 증가
                    visited[nx][ny] = true; // 다음 위치를 방문했음을 표시
                }
            }
        }

        return -1; // 목표 지점에 도달할 수 없는 경우 -1 반환
    }


    // 좌표가 미로 범위 내에 있는지 확인
    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    // 좌표를 저장하는 클래스
    static class Point {
        int x, y, count;
        
        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
}
