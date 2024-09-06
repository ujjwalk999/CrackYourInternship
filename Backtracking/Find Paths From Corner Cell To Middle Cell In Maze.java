
class Solution {
    public int[][] ShortestDistance(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        if (solveMaze(matrix, 0, 0, result)) {
            return result;
        } else {
            return new int[][]{}; // or throw an exception
        }
    }

    private boolean solveMaze(int[][] matrix, int i, int j, int[][] result) {
        int n = matrix.length;
        if (i == n - 1 && j == n - 1) {
            result[i][j] = 1;
            return true;
        }

        if (i < 0 || j < 0 || i >= n || j >= n || matrix[i][j] == 0 || result[i][j] == 1) {
            return false;
        }

        result[i][j] = 1;

        for (int k = 1; k <= matrix[i][j]; k++) {
            if (j + k < n && solveMaze(matrix, i, j + k, result)) {
                return true;
            }
            if (i + k < n && solveMaze(matrix, i + k, j, result)) {
                return true;
            }
        }

        result[i][j] = 0;
        return false;
    }
}
