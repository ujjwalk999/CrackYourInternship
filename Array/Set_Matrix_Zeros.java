class Solution {
    public void setZeroes(int[][] matrix) {
            ArrayList<int[]> ar = new ArrayList<>();
            for(int i =0; i<matrix.length;i++){
                for(int j =0 ; j<matrix[0].length;j++){
                    if(matrix[i][j]==0){
                        int []temp = {i,j};
                        ar.add(temp);
                    }
                }
            }
            solve(ar,matrix);

    }
            public static void solve(ArrayList<int[] >ar, int [][] matrix){
                for(int i =0; i<ar.size();i++){
                    int c[] = new int [2];
                    c= ar.get(i);
                    int row = c[0];
                    int col = c[1];
                    for(int j = 0; j<matrix[0].length; j++){
                        matrix[row][j]=0;
                    }
                    for(int j = 0; j<matrix.length; j++){
                        matrix[j][col] =0;
                    }
                }
            }
}
