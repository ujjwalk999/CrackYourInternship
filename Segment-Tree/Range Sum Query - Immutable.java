class NumArray {
     int res[];
    public NumArray(int[] nums) {
        this.res = new int[nums.length];
        this.res[0]= nums[0];


        for(int i =1; i<nums.length; i++){
            this.res[i] = this.res[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return left > 0? this.res[right] - this.res[left-1]:this.res[right];
    }
}
