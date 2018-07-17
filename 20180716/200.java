class Solution {
    private int num = 0;
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    explore(grid, i, j);
                    num++;
                }
            }
        }
        return num;
        
    }
    
    private void explore(char[][] grid, int i, int j) {
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
            grid[i][j] = 0;
            explore(grid, i-1, j);
            explore(grid, i+1, j);
            explore(grid, i, j-1);
            explore(grid, i, j+1);
        }
    }
}
