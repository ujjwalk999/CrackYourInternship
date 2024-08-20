class Solution {
    public int maxPathSum(TreeNode root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxp(root,maxValue);
        return maxValue[0];
        
    }

    private int maxp( TreeNode node, int [] maxValue){
        if(node == null){
            return 0;
        }
        int left = Math.max(0,maxp(node.left, maxValue));
        int right = Math.max(0,maxp(node.right , maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
