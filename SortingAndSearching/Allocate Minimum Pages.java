 class Solution {
    static boolean isPossible(int arr[], int n, int m, int curr_min) {
        int studentsRequired = 1;
        int curr_sum = 0;
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            if (curr_sum > curr_min) {
                studentsRequired++;
                curr_sum = arr[i];
            }
        }
        return studentsRequired <= m;
    }

    static int findPages( int n, int arr[], int m) {
        if (n < m) return -1;
        int sum = 0;
        int mx = arr[0];
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            mx = Math.max(arr[i], mx);
        }
        int start = mx, end = sum;
        int result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(arr, n, m, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

   
}
