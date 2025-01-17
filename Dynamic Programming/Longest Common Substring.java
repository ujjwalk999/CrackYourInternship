class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        int m = str1.length();
        int n = str2.length(); // Get the length of the second string
        int[][] dp = new int[m + 1][n + 1]; // Use a 2D array for dynamic programming
        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
