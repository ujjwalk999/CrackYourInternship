class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int data = root.val;
        int leftAns = 0;
        int rightAns = 0;
        if(data>=low && data<= high){
            leftAns = rangeSumBST(root.left,low,high);
            rightAns = rangeSumBST(root.right,low,high);
        }
        else if(data < low){
            rightAns = rangeSumBST(root.right,low,high);
        }
        else{
            leftAns = rangeSumBST(root.left,low,high);
        }
        if(data >= low && data <= high){
            return leftAns + rightAns + data;
        }
        return leftAns+rightAns;
    }
}
