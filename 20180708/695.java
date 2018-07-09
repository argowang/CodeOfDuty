class Solution {
    private int maxResult = 0;
    private boolean[][] visited;
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int I = grid.length;
        int J = grid[0].length;
        visited = new boolean[I][J];
        
        for (int i = 0; i < I; i++){
            for (int j = 0; j < J; j++) {
                maxResult = Math.max(maxResult, explore(grid, i, j));
            }
        }
        return maxResult;
    }
    
    public int explore(int[][] grid, int i, int j) {
        // the point needs to be within the graph, unvisited and being equal to 1 in order to be processed
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            return 1 + explore(grid, i-1, j) + explore(grid, i+1, j) + explore(grid, i, j-1) + explore(grid, i, j+1);
        }
        return 0;
    }
}
