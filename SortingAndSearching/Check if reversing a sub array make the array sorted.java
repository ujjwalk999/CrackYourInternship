class Solution {
    public boolean arraySortedOrNot(List<Integer> arr) {
        // code here
        for(int i=0; i<arr.size()-1; i++){
            int j =i+1;
            if(arr.get(j) < arr.get(i)){
                return false;
            }
        }
        return true;
    }
}
