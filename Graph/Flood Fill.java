class Solution {
    private void dfs( int sr, int sc,int delrow[],int delcol[],int[][] image,int ans [][],  int initialcolor, int color){
        ans[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        for(int i = 0; i<4; i++){
            int newrow = sr + delrow[i];
            int newcol = sc + delcol[i];
            if(newrow >=0  && newcol >= 0 && newrow < m && newcol < n && image[newrow][newcol] == initialcolor && ans[newrow][newcol] != color){
                dfs(newrow,newcol,delrow,delcol,image,ans,initialcolor,color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initialcolor = image[sr][sc];
        int ans [][] = image;
        int delrow[]={1,0,-1,0};
        int delcol[] = {0,1,0,-1};
        dfs(sr,sc,delrow,delcol,image,ans,initialcolor,color);
        return ans; 
    }
}
