class Solution {
    Map<Long , Integer>hmap;
        int count;
    public int pathSum(TreeNode root, int targetSum) {
        hmap = new HashMap<>();
        count =0;
        dfs(root,0,targetSum);
        return count;
    }

    private void dfs(TreeNode root, long prefixsum,int targetSum ){
        if(root ==  null) return ;
        prefixsum += root.val;

        if(hmap.containsKey(prefixsum - targetSum)){
            count += hmap.get(prefixsum - targetSum);
        }
        if(targetSum == prefixsum){
            count++;
        }
        hmap.put(prefixsum , hmap.getOrDefault(prefixsum,0)+1);
        dfs(root.left,prefixsum,targetSum);
        dfs(root.right,prefixsum,targetSum);

        hmap.put(prefixsum,hmap.get(prefixsum)-1);
    }
}
