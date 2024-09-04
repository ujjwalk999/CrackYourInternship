class Solution {
    
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int locX = location.get(0);
        int locY = location.get(1);
        double angleRad = Math.toRadians(angle);
        List<Double> angles = new ArrayList<>();
        int dupeCnt = 0;

        int maxManhatDist = 0;
        for(List<Integer> point : points) {
            maxManhatDist = Math.max(maxManhatDist, Math.abs(locX-point.get(0)) + Math.abs(locY-point.get(1)));
        }
        if(maxManhatDist == 0) return points.size(); //all duplicates of location
        final int roundScaleFactor = 2*maxManhatDist; //precision of angles = 1/roundScaleFactor, scale the precision with max dist as precision matters less at closer values

        int sizeScaled = 360 * roundScaleFactor;
        int[] angleScaledCnt = new int[sizeScaled];
        for(List<Integer> point : points) {
            if(point.get(0) == locX && point.get(1) == locY) {
                dupeCnt++;
                continue;
            }
            double currAngle = Math.toDegrees(Math.atan2(locY-point.get(1), locX-point.get(0)));
            if(currAngle < 0) currAngle += 360;
            int angleScaled = (int)(currAngle*roundScaleFactor);

            angleScaledCnt[angleScaled]++;
        }

        for(int i = 1; i < sizeScaled; i++) {
            angleScaledCnt[i] += angleScaledCnt[i-1];
        }
        int allowedRange = angle * roundScaleFactor;
        int maxWindow = angleScaledCnt[allowedRange];
    
        for(int left = 0; left < sizeScaled; left++) {
            int right = angleScaledCnt[(left+allowedRange+1) % sizeScaled] + (left+allowedRange+1 >= sizeScaled ? angleScaledCnt[sizeScaled-1] : 0);
            maxWindow = Math.max(maxWindow, right - angleScaledCnt[left]);
        }

        return maxWindow + dupeCnt;
    }

}
