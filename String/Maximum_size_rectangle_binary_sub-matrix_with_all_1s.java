import java.util.Stack;

//Maximum size rectangle binary sub-matrix with all 1s
public class Solution {
    public static int largestRectangleArea(int[] histogram) {
        // Calculate the maximum area of a rectangle that can be formed from a given
        // histogram
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = histogram.length;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || histogram[st.peek()] >= histogram[i])) {
                int height = histogram[st.pop()];
                int width;
                if (st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            st.push(i);
        }
        return maxArea;
    }

    public static int maximalAreaOfSubMatrixOfAll1(int[][] matrix, int n, int m) {
        // Calculate the maximum area of a sub-matrix consisting of all 1's in a given
        // binary matrix
        int maxArea = 0;
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1)
                    height[j]++;
                else
                    height[j] = 0;
            }
            int area = largestRectangleArea(height);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
