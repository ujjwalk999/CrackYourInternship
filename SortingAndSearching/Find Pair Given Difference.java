class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        
    HashSet<Integer> check = new HashSet<>();
    for(int i= 0 ; i<n ; i++){
        if(check.contains(arr[i]-x) || check.contains(arr[i]+x) ){
            return 1;
        }
        check.add(arr[i]);
    }
    return -1;
    }
}
