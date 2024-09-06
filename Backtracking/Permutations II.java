class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        backtrack(nums,result,new ArrayList<>(),used);
        return  result;
    }

    private  void backtrack(int [] nums , List<List<Integer>> result, ArrayList<Integer> templist ,boolean [] used){
       int n = nums.length;
        if( (templist.size() == n) && !result.contains(templist)){
            result.add(new ArrayList<>(templist));
            return;
        }

        for(int i = 0 ; i<n  ; i++){
             if(used[i]) continue;
             used[i]= true;
             templist.add(nums[i]);
             backtrack(nums,result,templist,used);
             used[i] = false;
             templist.remove(templist.size() -1);
        }
    }
}
