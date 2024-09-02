

class Solution {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sort the jobs in descending order of their profits
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        // Find the maximum deadline
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        // Create a result array to store the scheduled jobs
        int result[] = new int[maxi + 1];

        // Initialize the result array with -1
        for (int i = 1; i <= maxi; i++) {
            result[i] = -1;
        }

        // Initialize the count of scheduled jobs and the total profit
        int countJobs = 0, jobProfit = 0;

        // Iterate over the sorted jobs
        for (int i = 0; i < n; i++) {
            // Iterate over the time slots in reverse order
            for (int j = arr[i].deadline; j > 0; j--) {
                // If a free time slot is found, schedule the job
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }

        // Return the count of scheduled jobs and the total profit
        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;
    }
}
