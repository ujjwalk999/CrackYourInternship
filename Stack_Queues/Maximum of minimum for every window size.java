class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] arr, int n) 
    {
        int left[] = new int [n];
        int right [] = new int [n];
        int ans[] = new int [n];
        
        Stack<Integer> s1 =  new Stack<Integer>();
        
        for(int i = 0 ; i<n ; i++){
            while(!s1.isEmpty() && arr[s1.peek()] >= arr[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                left[i] = -1;
            }
            else{
                left[i] = s1.peek();
            }
            s1.push(i);
        }
        Stack<Integer> s2 = new Stack<>();
        for(int i = n-1; i>=0;i--){
              while(!s2.isEmpty() && arr[s2.peek()] >= arr[i]){
                s2.pop();
            }
             if(s2.isEmpty()){
                right[i] = n;
            }
            else{
                right[i] = s2.peek();
            }
            s2.push(i);
            
        }
        int index;
        for(int i =0; i<n; i++){
            index = right[i] - left[i] -1;
            if(arr[i] > ans[index-1]){
                ans[index-1] = arr[i];
            }
        }
        int max  = ans[n-1];
        for(int i = n-2; i>=0; i--){
            max = Math.max(max, ans[i]);
            ans[i] = max;
        }
        
        return ans;
    }
}
