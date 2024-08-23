
class Solution {
    public int minSteps(int m, int n, int d) {
        if (d > Math.max(m, n)) {
            return -1;
        }
        if (d == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0, 0});
        visited.add("0,0");
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int x = state[0];
            int y = state[1];
            int step = state[2];
            if (x == d || y == d) {
                return step;
            }
            if (x < m) {
                if (!visited.contains((m + "," + y))) {
                    queue.add(new int[]{m, y, step + 1});
                    visited.add(m + "," + y);
                }
            }
            if (y < n) {
                if (!visited.contains((x + "," + n))) {
                    queue.add(new int[]{x, n, step + 1});
                    visited.add(x + "," + n);
                }
            }
            if (x > 0) {
                if (!visited.contains(("0," + y))) {
                    queue.add(new int[]{0, y, step + 1});
                    visited.add("0," + y);
                }
            }
            if (y > 0) {
                if (!visited.contains((x + "," + 0))) {
                    queue.add(new int[]{x, 0, step + 1});
                    visited.add(x + "," + 0);
                }
            }
            int pour = Math.min(x, n - y);
            if (!visited.contains(((x - pour) + "," + (y + pour)))) {
                queue.add(new int[]{x - pour, y + pour, step + 1});
                visited.add((x - pour) + "," + (y + pour));
            }
            pour = Math.min(y, m - x);
            if (!visited.contains(((x + pour) + "," + (y - pour)))) {
                queue.add(new int[]{x + pour, y - pour, step + 1});
                visited.add((x + pour) + "," + (y - pour));
            }
        }
        return -1;
    }
}
