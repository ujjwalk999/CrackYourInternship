class Solution {
    public void gameOfLife(int[][] board) {
       int m =board.length;
       int n =board[0].length;
       //int rs[][] = new int [m][n];
       int dir [][]= new int [][]{{-1,-1},{1,1},{-1,1},{1,-1},{-1,0},{1,0},{0,-1},{0,1}};
       for(int i =0 ; i<m; i++){
        for(int  j =0; j<n; j++){
            int count =0;
            for(int[]d:dir){
                int nr = i+d[0];
                int nc = j+d[1];
                if( nr>=0 && nr<m && nc>=0 && nc<n && (board[nr][nc]==1 || board[nr][nc]==2)){
                    count++;
                }
        }
        if(board[i][j]==1){
            if( count<2 || count>3){
                board[i][j]=2;
            }
        }
        else{
            if(count == 3){
                board[i][j]=3;
            }
        }
       }
       }
       for(int i =0; i<m; i++){
        for(int j =0; j<n; j++){
            //board[i][j]=rs[i][j];
            board[i][j]%=2;
        }
       }
    }
}
