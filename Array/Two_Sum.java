class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0 ; i<nums.length ; i++ ){
            int remain = target - nums[i];
            if(mpp.containsKey(remain)  ){
                return new int[]{mpp.get(remain),i};
            }
            mpp.put(nums[i],i);
        }
        return null;
      

        }
    }
