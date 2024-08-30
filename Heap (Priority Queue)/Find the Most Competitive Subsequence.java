class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int result [] = new int[k];
        int top = 0;
        for(int i=0;i<nums.length; i++){
            while(top>0 && nums[i] < result[top-1] && top + nums.length -i > k){
                top--;
            }
            if(top<k){
                result[top++] = nums[i];
            }
        }
        return result;
    }
}
