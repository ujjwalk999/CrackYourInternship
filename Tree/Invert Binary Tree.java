class Solution {
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
    private void swap(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        swap(root.left);
        swap(root.right);
    }
}
