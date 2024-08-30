class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> que = new PriorityQueue <>();
        for(int i = 1 ; i < heights.length; i++){
        int diff = heights[i] - heights[i-1];
        if(diff>0){
            if(que.size() < ladders){
                que.offer(diff);
            }
            else{
                int br = diff;
                if(que.size() > 0 && que.peek() < diff){
                    br = que.remove();
                    que.offer(diff);
                }
                if(bricks - br >=0){
                    bricks -= br;

                }
                else{
                    return i-1;
                }
            }
        }
        }
        return heights.length-1;
    }
}
