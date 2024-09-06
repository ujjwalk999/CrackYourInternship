/*You are required to complete this method */
class Solution {
    public boolean isKPartitionPossible(int a[], int n, int k) {
        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }
        
        if (totalSum % k != 0) {
            return false;
        }
        
        int targetSum = totalSum / k;
        boolean[] visited = new boolean[n];
        return backtrack(a, visited, k, targetSum, 0, 0);
    }
    
    private boolean backtrack(int a[], boolean[] visited, int k, int targetSum, int currSum, int startIndex) {
        if (k == 0) {
            return true;
        }
        
        for (int i = startIndex; i < a.length; i++) {
            if (visited[i] || currSum + a[i] > targetSum) {
                continue;
            }
            
            visited[i] = true;
            if (currSum + a[i] == targetSum) {
                if (backtrack(a, visited, k - 1, targetSum, 0, 0)) {
                    return true;
                }
            } else {
                if (backtrack(a, visited, k, targetSum, currSum + a[i], i + 1)) {
                    return true;
                }
            }
            visited[i] = false;
        }
        
        return false;
    }
}
