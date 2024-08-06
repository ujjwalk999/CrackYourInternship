class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long result [] = new long  [ nums.length];
        long mul = 1;
        for(int i = 0; i<nums.length ;i++){
           result[i] = mul;
           mul*=nums[i];
        }
           mul = 1;
        for(int i = nums.length-1; i>=0; i--){
            result[i]*=mul;
            mul*=nums[i];
        }
        
        return result;
    }
}
