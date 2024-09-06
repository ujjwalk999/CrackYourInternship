class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        backtrack(nums,n,result, new ArrayList<>(),0);
        return result;
    }
  private void  backtrack(int []nums,int n,  List<List<Integer>> result, ArrayList<Integer>templist, int ind){
        result.add(new ArrayList<>(templist));
        for(int  i =ind ; i<n; i++){
           templist.add(nums[i]);
           backtrack(nums,n,result,templist,i+1);
           templist.remove(templist.size()-1);
        }
    }
}
