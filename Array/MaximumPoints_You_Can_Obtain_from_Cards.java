class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int leftsum = 0;
    int rightsum = 0;
    int maxsum = 0;
    for(int i = 0; i<k ; i++){
        leftsum = leftsum + cardPoints[i];
        maxsum = leftsum;
    }
    int rightindex = n-1;
    for(int j = k-1; j>=0; j--){
       leftsum = leftsum - cardPoints[j];
       rightsum = rightsum + cardPoints[rightindex];
       rightindex = rightindex-1;
        maxsum = Math.max(maxsum, ( leftsum + rightsum));
    }
    return maxsum;
    }
}
