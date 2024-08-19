class Solution {
    int ans=0;
    public int minCameraCover(TreeNode root) {
        return sol(root)==-1?ans+1:ans;
    }
    public int sol(TreeNode root){
        if(root==null) return 1;
        if(root.left==null && root.right==null) return -1;
        int l=sol(root.left);
        int r=sol(root.right);
        if(l==-1 || r==-1){
            ans++;
            return 0;
        }
        if(l==0 || r==0) return 1;
        return -1;
    }
}
