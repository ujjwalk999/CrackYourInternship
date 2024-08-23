class Solution {
    int[][] dp;
    int n;
    int INF = (int)1e9;

    public int total_cost(int[][] cost) {
        n = cost.length;
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }
        return tsp(0, 1, cost);
    }

    public int tsp(int node, int mask, int[][] cost) {
        if (mask == (1 << n) - 1) {
            return cost[node][0];
        }
        if (dp[node][mask] != -1) {
            return dp[node][mask];
        }
        int ans = INF;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                int newMask = mask | (1 << i);
                ans = Math.min(ans, cost[node][i] + tsp(i, newMask, cost));
            }
        }
        return dp[node][mask] = ans;
    }
}
