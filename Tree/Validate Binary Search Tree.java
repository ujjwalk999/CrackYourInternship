class Solution {
    long Prev = Long.MIN_VALUE;

    void inorder(TreeNode a, boolean[] Is) {
        if (a == null){
            return;
        }
        inorder(a.left, Is);
        if (a.val <= Prev){
            Is[0] = false;
        }
        Prev = a.val;
        inorder(a.right, Is);
    }

    public boolean isValidBST(TreeNode a) {
        boolean[] Is = {true};
        inorder(a, Is);
        return Is[0];
    }
}
