class Solution {
    public boolean isPossible(int N, int P, int[][] prerequisites) {
        if (N == 1) {
            return true;
        }

        List<Integer>[] graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N];

        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
