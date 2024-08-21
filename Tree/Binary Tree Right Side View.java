class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        rightview(root, arr, 0);
        return arr;
    }
    public void rightview(TreeNode root , List<Integer> arr,  int currlevel){
        if(root ==  null){
            return;
        }
        if( currlevel == arr.size()){
            arr.add(root.val);
        }
        rightview(root.right,  arr, currlevel+1 );
        rightview(root.left, arr, currlevel+1);
    }
}
