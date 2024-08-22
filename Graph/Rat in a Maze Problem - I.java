class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        int n = mat.length;
        ArrayList<String> result = new ArrayList<>();
        solve(mat,0,0,n,"",result);
        return result;
    }
    public  void solve(int[][] mat,int i,int j, int n,String path, ArrayList<String> result){
      if(i<0 || i >= n || j<0 || j  >= n || mat[i][j] == 0 || mat[i][j]==2){
          return;
      }
      if(i == n-1 && j == n-1 ){
          result.add(path);
      }
      int orign = mat[i][j];
      mat[i][j] = 2;
      solve(mat,i-1,j,n,path +'U',result);
      solve(mat,i+1,j,n,path + 'D',result);
      solve(mat,i,j-1,n,path + 'L',result);
      solve(mat,i,j+1,n,path + 'R', result);
      mat[i][j] = orign;
    }
}
