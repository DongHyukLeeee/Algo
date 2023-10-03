package Algo_231003;

public class MultipleKnapsack {

    public static int multipleKnapsack(int[] values, int[] weights, int[] quantities, int capacity, int N) {
        int[][] dp = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];
                for (int k = 1; k <= quantities[i] && k * weights[i] <= w; k++) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - k * weights[i]] + k * values[i]);
                }
            }
        }

        return dp[N][capacity];
    }

    public static void main(String[] args) {
        int N = 3; // 아이템 개수
        int[] values = {0, 60, 100, 120}; // 0번째 아이템은 무시
        int[] weights = {0, 10, 20, 30}; // 0번째 아이템은 무시
        int[] quantities = {0, 2, 1, 2}; // 각 아이템의 개수
        int capacity = 50;

        int maxValue = multipleKnapsack(values, weights, quantities, capacity, N);
        System.out.println("최대 가치: " + maxValue);
    }
}