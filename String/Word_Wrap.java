class Solution {
    public int solveWordWrap(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n + 1];
        for (int g = n; g >= 0; g--) {
            if (g == n) {
                dp[g] = 0;
            } else {
                int sum = 0, min = Integer.MAX_VALUE;
                for (int i = g; i < n; i++) {
                    sum += a[i];
                    if (g!= i)
                        sum++;
                    if (k >= sum) {
                        if (i + 1!= n) {
                            min = Math.min(min, (k - sum) * (k - sum) + dp[i + 1]);
                        } else
                            min = Math.min(min, dp[i + 1]);
                    } else
                        break;
                }
                dp[g] = min;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.solveWordWrap(new int[]{3, 2, 2, 5}, 6));
    }
}
