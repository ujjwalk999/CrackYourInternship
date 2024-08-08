class Solution
{
    public void swap(int arr[], int i, int j) {
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
    }
    public int minSwaps(int nums[])
    {
        Map<Integer, Integer> map = new HashMap<>();
            // sorted array elements and their index
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        
        for(int i = 0;i<numsSorted.length; i++) {
            map.put(numsSorted[i], i);
        }
        
        int swap = 0;
        int i = 0;
        while(i < nums.length) {
            if( map.get(nums[i]) == i ) {
                i++;
            } else {
                swap(nums, i, map.get(nums[i]));
                swap++;
            }
        }
        return swap;
    }
}
