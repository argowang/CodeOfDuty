class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] mark = new int[row][column];
        int globalMax = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 || j == 0) {
                    mark[i][j] = matrix[i][j] == '0' ? 0 : 1;
                } else if (matrix[i][j] == '1') {
                    mark[i][j] = Math.min(Math.min(mark[i-1][j-1], mark[i][j-1]), mark[i-1][j]) + 1;
                }
                globalMax = Math.max(mark[i][j], globalMax);
            }
        }
        return globalMax * globalMax;
    }
}
