class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int flag,i,ans=-1;
        for(i=0; i<mat.length; i++){
            flag=1;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                ans=i;
                break;
            }
        }
        if(ans==-1){
            return -1;
        }
        for(i=0; i<mat.length; i++){
            if(i==ans){
                continue;
            }
            if(mat[i][ans]==0){
                return -1;
            }
        }
        return ans;
        
    }
}
