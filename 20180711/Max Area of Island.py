class Solution(object):
    # def check_all_ones(self, grid, i, j, seen):
    #     future = [(i,j)]
    #     count = 0
    #     while future:
    #         r, c = future.pop(0)
    #         if grid[r][c] == 1 and (r,c) not in seen:
    #             count += 1
    #             seen.add((r,c))
    #             if (r > 0):
    #                 future.append((r-1, c))
    #             if( r < len(grid) - 1):
    #                 future.append((r+1, c))
    #             if (c > 0):
    #                 future.append((r, c - 1))
    #             if( c < len(grid[0]) - 1):
    #                 future.append((r, c + 1))
    #     return count, seen         
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # if (grid == None or len(grid) < 1):
        #     return 0
        # seen = set()
        # res = 0
        # for i in range(len(grid)):
        #     for j in range(len(grid[0])):
        #         if grid[i][j] == 1 and (i,j) not in seen:
        #             count, seen = self.check_all_ones(grid, i, j, seen)
        #             res = max(res, count)
        # return res
        def dfs(i, j):
            row = len(grid) - 1
            col = len(grid[0]) - 1
            if 0 <= i <= row and 0 <= j <= col and grid[i][j]:
                grid[i][j] = 0
                return 1 + dfs(i - 1, j) + dfs(i, j - 1) + dfs(i + 1, j) + dfs(i, j + 1)
            return 0
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]:
                    res = max(res, dfs(i, j))
        return res
            
        
        
        