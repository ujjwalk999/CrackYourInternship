class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int [n-k+1];
         if(n== 0){
            return res;
        }
        Deque<Integer> deq = new    ArrayDeque<Integer>();
       
        int index =0;
        while(index<k){
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[index]){
                deq.pollLast();
            }
            deq.offerLast(index);
            index++;
        }
        res[0] = nums[deq.peekFirst()];
        for(int i =1; i<n-k+1; i++){
            if(!deq.isEmpty() && deq.peekFirst() <= (i-1) ){
                deq.pollFirst();
            }
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i+k-1]){
                deq.pollLast();
            }
            deq.offerLast(i+k-1);
            res[i] = nums[deq.peekFirst()];
        }
        return res;
    }
}
