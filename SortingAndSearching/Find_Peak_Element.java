class Solution {
    long minAdjustmentCost(long A[], int n, int target) {
        long[][] dp = new long[n][101];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= 100; j++)
                dp[i][j] = Long.MAX_VALUE;

        for (int i = 1; i <= 100; i++)
            dp[0][i] = Math.abs(i - A[0]);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                for (int k = Math.max(1, j - target); k <= Math.min(100, j + target); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A[i]));
                }
            }
        }

        long minCost = Long.MAX_VALUE;
        for (int i = 1; i <= 100; i++)
            if (dp[n - 1][i] < minCost)
                minCost = dp[n - 1][i];

        return minCost;
    }
}
