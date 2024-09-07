class NumArray {
     private int nums[];
     private  int prefix[];
    public NumArray(int[] nums) {
        this.nums = nums;
        this.prefix = new int [nums.length +1];
        for(int i = 0; i<nums.length; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
    }
    
    public void update(int index, int val) {
        int oldval = nums[index];
        int diff = val - oldval;
        for(int  i = index+1; i<prefix.length; i++){
            prefix[i] += diff;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix[right+1]-prefix[left];
    }
}
