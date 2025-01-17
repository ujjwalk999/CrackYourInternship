class Solution {
    public boolean fun(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1==null || root2 == null){
            return false;
        }

        return root1.val==root2.val && fun(root1.left,root2.right) && fun(root1.right, root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root== null){
            return true;
        }
        return fun(root.left,root.right);
    }
}
