// User function Template for Java

class Solution {
    
    int[] delRow = {0, -1, 0, 1, 0};
    int[] delCol = {0, 0, 1, 0, -1};
    
    boolean isSafe(int row, int col, int[][] keypad){
        
        return row  < 4 && col < 3 && row >= 0 && col >= 0 && keypad[row][col] != -1;
    }
    
    long helper(int row, int col, int[][] keypad, int n, long[][][] dp){
        
        if(n == 1) return 1;
        
        
        if(dp[row][col][n] != -1) return dp[row][col][n];
        long result = 0;
        for(int i = 0; i < 5; i++)
        {
            
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            
            if(isSafe(nRow, nCol, keypad)){
                result += helper(nRow, nCol, keypad, n-1, dp);
            }
        }
        return dp[row][col][n] =  result;
    }
    public long getCount(int n) {
        // Your code goes here
        int[][] keypad = {
            {1, 2, 3},
            {4, 5, 6},
            {7,8, 9},
            {-1, 0, -1}
        };
        
        long[][][] dp = new long[4 + 1][3 + 1][n + 1];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        long result = 0;
        
        for(int i = 0; i < 4; i++){
            
            for(int j =0; j < 3; j++){
                if(keypad[i][j] == -1) continue;
                result += helper(i, j, keypad, n, dp);
            }
        }
        
        return result;
    }
}
