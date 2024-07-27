class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        Collections.sort(a);
        long maxi = Long.MAX_VALUE;
        for(int i =0; i<= n-m; i++ ){
            int min = a.get(i);
            int max =a.get(i+m-1);
            maxi = Math.min(maxi, (max-min));
        }
        return maxi;
    }
}
