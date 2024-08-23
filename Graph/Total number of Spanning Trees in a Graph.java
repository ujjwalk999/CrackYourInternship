class Solution {
    
    private static int determinantOfMatrix(int matrix[][], int n){
        if(matrix.length==1) return matrix[0][0];
        
        int res = 0;
        
        for(int i=0; i<matrix.length; i++){
            int temp[][] = new int[n-1][n-1];
            for(int j=1; j<matrix.length; j++){
                int idx = 0;
                for(int k=0; k<matrix.length; k++)
                    if(k!=i) temp[j-1][idx++]=matrix[j][k];
            }
            res+=(i%2==0?1:-1)*matrix[0][i]*determinantOfMatrix(temp, n-1);
        }
        
        return res;
    }
    
    public static int countSpanningTrees(int[][] graph,int n,int m) {
        int adj[][] = new int[n][n];
        
        int diag[] = new int[n];
        
        for(int el[]: graph){
            int u = el[0];
            int v = el[1];
            adj[u][v]++;
            adj[v][u]++;
            diag[u]++;
            diag[v]++;
        }
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(adj[i][j]==1) adj[i][j]=-1;
                
        for(int i=0; i<n; i++)
            adj[i][i]=diag[i];
            
        int temp[][] = new int[n-1][n-1];
        for(int i=1; i<n; i++)
            for(int j=1; j<n; j++)
                temp[i-1][j-1]=adj[i][j];
        
        return determinantOfMatrix(temp,n-1);
        
        
    }
}
