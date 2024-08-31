class Solution
{
    //Function to find the maximum number of cuts.
    public int find( int n , int x , int y , int z , int dp[] ){
        // base case 
        if( n == 0 ) return 0;
        if( dp[n] != -1 ) return dp[n]; 
        
        // if( n < 0 ) return Integer.MAX_VALUE;
        int a = Integer.MIN_VALUE,
        b = Integer.MIN_VALUE,
        c = Integer.MIN_VALUE; 
        
       if( x <= n)  a =  find( n-x , x, y, z, dp); 
       if( y <= n)  b =  find( n-y , x, y, z, dp); 
       if( z <= n)  c =  find( n-z , x, y, z, dp);
        
        return dp[n] = 1 + Math.max( a , Math.max(b,c)); 

    }
    public int maximizeCuts(int n, int x, int y, int z){
       //Your code here
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1); 
       int ans = find( n, x, y, z, dp);
       
       if( ans < 0 ) return 0; 
       return ans; 
       
       
    }
}
