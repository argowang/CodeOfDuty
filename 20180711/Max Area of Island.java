class Solution {
    public int dfs(int[][] grid, int i,int j){
        int row = grid.length - 1;
        int col = grid[0].length - 1;
        if (i >= 0 && i <= row && j >= 0 && j <= col && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + dfs(grid,i-1, j) + dfs(grid,i, j-1) + dfs(grid,i+1, j) + dfs(grid,i, j+1);
        }
        return 0;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid,i,j));
                }
            }
        }
        return res;
    }
}
