class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
        int count[]= new int [3];
        for(int i =0; i <nums.length; i++){
            int num = nums[i];
            count[num]++;
        }
        int i =0;
        for(int element = 0; element<3; element++){
            while(count[element]>0){
              nums[i]=element;
              i++;
              count[element]--;
            }
        }
    }
}
