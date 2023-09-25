package Algo_230926;
import java.util.Scanner;

public class BJ_17070_Pipe_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // dp[i][j][k]: (i, j) 위치에서 k 방향으로 파이프를 놓는 경우의 수
        int[][][] dp = new int[N][N][3];

        dp[0][1][0] = 1;  // 초기 시작 위치 (0, 1)에서 가로 방향으로 파이프를 놓는 경우의 수는 1

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (map[i][j] == 0) {
                    // 가로 방향으로 파이프 놓기
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    
                    // 세로 방향으로 파이프 놓기
                    if (i > 0 && map[i - 1][j] == 0) {
                        dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    }
                    
                    // 대각선 방향으로 파이프 놓기
                    if (i > 0 && map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        int answer = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(answer);
    }
}
