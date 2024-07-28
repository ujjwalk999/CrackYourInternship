class Solution {
    public List<Integer> findDuplicates(int[] nums) {
         List<Integer> ans = new ArrayList<>();
        int seen [] = new int[nums.length+1];
        for(int i :nums){
            if(seen[i]!=0){
                ans.add(i);
            }
            else{
                seen[i]=i;
            }
        }
        return ans;
    }
}
