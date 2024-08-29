class Solution {
  public static int wordBreak(String A, ArrayList<String> B) {
        int n = A.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j=0; j < i; j++) {
                if (dp[j] && B.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
       }
        
        return dp[n] ? 1 : 0;
  }
}
