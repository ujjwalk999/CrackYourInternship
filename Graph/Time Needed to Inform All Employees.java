class Solution {
    int maxTime = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adj[manager[i]].add(i);
            }
        }

        dfs(adj, informTime, headID, 0);
        return maxTime;
    }

    private void dfs(List<Integer>[] adj, int[] informTime, int node, int time) {
        maxTime = Math.max(maxTime, time);
        for (int child : adj[node]) {
            dfs(adj, informTime, child, time + informTime[node]);
        }
    }
}
