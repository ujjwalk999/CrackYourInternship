class Solution {
    
    public int largestRectangleArea(int[] heights) {
      int n = heights.length;
      int [] stt = new int [n+1];
      int index = 0;
      int maxi = Integer.MIN_VALUE;
      for(int i =0; i <=n; i++){
        int number = (i==n)?0 : heights[i];
        while(index != -1 && heights[stt[index]] >= number){
            int h = heights[stt[index--]];
            int ps = (index == -1)?-1:stt[index];
            int w = i- ps -1;
            maxi = Math.max(maxi,(h*w));
        }
        stt[++index] = i;

      }
      return (maxi == Integer.MIN_VALUE)?0:maxi;
    }
}
