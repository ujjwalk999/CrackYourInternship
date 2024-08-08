class Solution {
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        // Handle edge case where array is empty
        if (size == 0) {
            return 1;
        }

        // Iterate over the array to place elements at their correct indices
        for (int i = 0; i < size; i++) {
            while (arr[i] > 0 && arr[i] <= size && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }

        // Iterate over the array to find the smallest positive missing number
        for (int j = 0; j < size; j++) {
            if (arr[j] != j + 1) {
                return j + 1;
            }
        }

        // If all numbers from 1 to size are present, return size + 1
        return size + 1;
    }
}
