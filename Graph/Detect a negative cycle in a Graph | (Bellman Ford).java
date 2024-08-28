class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = 10000000;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] + w < dist[v]) {
                return 1; // Negative weight cycle detected
            }
        }

        return 0; // No negative weight cycle
    }
}
