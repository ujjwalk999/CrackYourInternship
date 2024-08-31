class Solution {
    int[][] direction = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    record Point(int x, int y) {}
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        Queue<Point> q = new PriorityQueue<>((a,b)->grid[a.x][a.y]-grid[b.x][b.y]);
        Set<Point> visited = new HashSet<>();
        Point start = new Point(0,0);
        Point end = new Point(n-1,n-1);
        q.offer(start);
        visited.add(start);
        int level = grid[0][0];
        while(q.size()>0) {
            Point curr = q.poll();
            level=Math.max(level, grid[curr.x][curr.y]);
            if(curr.equals(end)) {
                return level;
            }
            for(var dir : direction) {
                int x = curr.x+dir[0];
                int y = curr.y+dir[1];
                if(x>=0&&x<n&&y>=0&&y<n) {
                    Point next = new Point(x,y);
                    if(visited.contains(next)) continue;
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
