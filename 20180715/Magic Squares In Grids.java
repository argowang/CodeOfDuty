class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length < 3 || grid[0].length < 3){
            return 0;
        }
        int res = 0;
        for(int i = 2; i < grid.length; i ++){
            for(int j = 2; j < grid[0].length; j++){
                int row1_sum = grid[i-2][j-2] + grid[i-2][j-1] + grid[i-2][j];
                int row2_sum = grid[i-1][j-2] + grid[i-1][j-1] + grid[i-1][j];
                int row3_sum = grid[i][j-2] + grid[i][j-1] + grid[i][j];
                if (row1_sum + row2_sum + row3_sum == 45 && row1_sum == 15 && row2_sum == 15 && row3_sum == 15){
                    int col1_sum = grid[i-2][j-2] + grid[i-1][j-2] + grid[i][j-2];
                    int col2_sum = grid[i-2][j-1] + grid[i-1][j-1] + grid[i][j-1];
                    int col3_sum = grid[i-2][j] + grid[i-1][j] + grid[i][j];
                    if (col1_sum == 15 && col2_sum == 15 && col3_sum == 15){
                        if (grid[i-2][j-2] + grid[i][j] == grid[i-2][j] + grid[i][j-2]){
                            boolean label = true;
                            for(int m = 0; m < 3; m++){
                                for(int n = 0; n < 3; n++){
                                    if(grid[i-m][j-n] < 1 || grid[i-m][j-m] > 9){
                                        label = false;
                                    }
                                }
                            }
                            if (label){
                                res += 1;
                            }
                        }
                    }

                }

            }
        }
        return res;
    }
}
