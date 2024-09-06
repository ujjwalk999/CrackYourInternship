
class Solution {
      public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
      
      boolean [] vis=new boolean[n];
      minDiff=Integer.MAX_VALUE;
     
     
         helper(0, vis, 0, arr);
        
      ArrayList<ArrayList<Integer>> f=new ArrayList();
     for(int i=0;i<2;i++){
         ArrayList<Integer> s=new ArrayList<>();
         s.add(ans[i]);
         f.add(s);
     }
     return f;
      } 
      static int minDiff=Integer.MAX_VALUE;
      static int [] ans=new int [2];
      static void helper(int start, boolean [] vis,int counter,int[] arr){
              if (counter== arr.length / 2) {
            int sum1 = 0, sum2 = 0;
            
            // Calculate the sum of both subsets
            for (int i = 0; i < arr.length; i++) {
                if (vis[i]) {
                    sum1 += arr[i];
                } else {
                    sum2 += arr[i];
                }
            }
            
            // Update the minimum difference if the current split is better
            int diff = Math.abs(sum1 - sum2);
            if (diff < minDiff) {
                minDiff = diff;
                ans[0] = sum1;
                ans[1] = sum2;
            }
            
            return;  // Early return after finding a valid subset
        }
       for(int i=start;i<arr.length;i++){
           if(!vis[i]){
               vis[i]=true;
               
               helper(i+1,vis,counter+1,arr);
               vis[i]=false;
               
           }
       }
       
      }   
}
