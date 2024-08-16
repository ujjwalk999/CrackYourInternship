class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int dia [] =  new int[1];
        height(root , dia);
        return dia[0];
        
    }

    public int height(TreeNode root , int [] dia){
        if(root == null){
            return 0;
        }
    
    int left = height(root.left ,dia);
    int right = height(root.right, dia);
    dia[0] = Math.max(dia[0], left + right);

    return Math.max(left,right)+1;
    }
}
