

class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int m = a.length;
        int n = a[0].length;
        int[][] arr = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                arr[i][j] = a[i][j] + (j > 0 ? arr[i][j - 1] : 0);
            }
        }
        int maxi = 0;
        int startrow = 0;
        int startcol = 0;
        int endrow = -1;
        int endcol = -1;
        int target = 0;
        for(int i = 0;i < n;i++){
            for(int j = i;j < n;j++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                int currsum = 0;
                for(int k = 0;k < m;k++){
                    int prev = i > 0 ? arr[k][i - 1] : 0;
                    currsum += arr[k][j] - prev;
                    int key = currsum - target;
                    if(map.containsKey(key)){
                        int area = (j - i + 1) * (k - map.get(key));
                        if(area > maxi){
                            maxi = area;
                            startrow = map.get(key) + 1;
                            endrow = k;
                            startcol = i;
                            endcol = j;
                        }
                    }
                    else{
                        map.put(currsum, k);
                    }
                }
            }
        }
        if(maxi == 0){
            return result;
        }
        for(int i = startrow; i <= endrow;i++){
            ArrayList<Integer> l = new ArrayList<>();
            for(int j = startcol;j <= endcol;j++){
                l.add(a[i][j]);
            }
            result.add(l);
        }
        return result;
    }
}
        
