class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result,nums, new ArrayList<Integer>() ,0);
        return result;
    }
    private void backtrack(List<List<Integer>> result,int[] nums, List<Integer>temp,int ind){
       
       

         result.add(new ArrayList<>(temp));

        for(int i = ind ; i<nums.length; i++){
            if (i > ind && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(result,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
}
}
