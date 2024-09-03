class Solution {
    public int maximalRectangle(char[][] matrix) {
        int [] max = new int [matrix[0].length];
        int largest = 0;

        for(int i =0; i<matrix.length ; i++){
            for(int j =0; j<matrix[i].length; j++){
                int val = matrix[i][j]-'0';
                if(val==0){
                    max[j]=0;
                }
                else{
                    max[j] += val;
                }
            }
            int maxarea = findmax(max);
            if(maxarea>largest){
                largest = maxarea;
            }
        }
        return largest;
    }

    public int findmax(int max[]){
        int n = max.length;
        int index = 0;
        int res[] = new int[n+1];
        int maxi=Integer.MIN_VALUE;
        for(int i =0; i<=n; i++){
            int number = (i==n)?0:max[i];
            while(index!=-1 && max[res[index]] >= number){
                int h = max[res[index--]];
                int ps = (index == -1)?-1:res[index];
                int w = i - ps -1;
                maxi = Math.max(maxi,(h*w));

            }
            res[++index]=i;
        }
        return (maxi==Integer.MIN_VALUE)?0:maxi;
    }
}
