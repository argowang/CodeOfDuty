class Solution(object):
    def numMagicSquaresInside(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if len(grid) < 3 or len(grid[0]) < 3:
            return 0
        res = 0
        for i in range(2, len(grid)):
            for j in range(2, len(grid[0])):
                row1_sum = grid[i-2][j-2] + grid[i-2][j-1] + grid[i-2][j]
                row2_sum = grid[i-1][j-2] + grid[i-1][j-1] + grid[i-1][j]
                row3_sum = grid[i][j-2] + grid[i][j-1] + grid[i][j]
                if row1_sum + row2_sum + row3_sum == 45 and row1_sum == 15 and row2_sum == 15 and row3_sum == 15:
                    col1_sum = grid[i-2][j-2] + grid[i-1][j-2] + grid[i][j-2]
                    col2_sum = grid[i-2][j-1] + grid[i-1][j-1] + grid[i][j-1]
                    col3_sum = grid[i-2][j] + grid[i-1][j] + grid[i][j]
                    if col1_sum == 15 and col2_sum == 15 and col3_sum == 15:
                        if grid[i-2][j-2] + grid[i][j] == grid[i-2][j] + grid[i][j-2]:
                            label = True
                            for m in range(3):
                                for n in range(3):
                                    if grid[i-m][j-n] < 1 or grid[i-m][j-n] > 9:
                                        label = False
                            if label:
                                res += 1
        return res
        
