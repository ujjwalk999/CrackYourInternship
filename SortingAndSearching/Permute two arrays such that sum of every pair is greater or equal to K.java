class Solution {
    public boolean isPossible(int k, int[] arr1, int[] arr2) {
       Arrays.sort(arr1);
       Arrays.sort(arr2);
       
        int left = 0;
        int right = arr2.length - 1;
        while (left < right) {
            int temp = arr2[left];
            arr2[left] = arr2[right];
            arr2[right] = temp;
            left++;
            right--;
        }
        
        for(int i = 0 ; i < arr1.length; i++){
          if(arr1[i]+arr2[i]<k){
              return false;
          } 
        }
       
         return true;
    }
}
