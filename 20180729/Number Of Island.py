# Union Find Algorithm:
class Union():
    def __init__(self, m, n, grid):
        self.count = 0
        self.parent = [0 for j in range(n) for i in range(m)]
        self.rank = [0 for i in range(m*n)]
        self.union_find(m,n,grid)

    def union_find(self, m,n,grid):
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    self.parent[i*n + j] = i*n + j
                    self.count += 1

    def find(self,p):
        while self.parent[p] != p:
            p = self.parent[p]
        return p

    def union(self, x,y):
        p_x = self.find(x)
        p_y = self.find(y)
        if p_y == p_x:
            return False
        else:
            if self.rank[p_x] > self.rank[p_y]:
                self.parent[p_y] = p_x
            elif self.rank[p_y] > self.rank[p_x]:
                self.parent[p_x] = p_y
            else:
                self.parent[p_x] = p_y
                self.rank[p_y] += 1 
            self.count -= 1
        return True

    def getCount(self):
        return self.count
        
class Solution(object):           
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        if n == 0:
            return 0
        # Initializing
        union = Union(m,n,grid)
        # Union Find
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    grid[i][j] = "0"
                    if i >= 1 and grid[i-1][j] == "1":
                        union.union(i*n+j, (i-1)*n + j)
                    if j >= 1 and grid[i][j-1] == "1":
                        union.union(i*n+j, i*n + (j-1))
                    if i <= m - 2 and grid[i+1][j] == "1":
                        union.union(i*n + j, (i+1)*n + j)
                    if j <= n - 2 and grid[i][j+1] == "1":
                        union.union(i*n + j, i*n + j + 1)
        return union.getCount()
        
# DFS method:
class Solution(object):           
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        def dfs(grid, i,j):
            m = len(grid)
            n = len(grid[0])
            if 0 <= i <= m-1 and 0 <= j <= n-1 and grid[i][j] == "1":
                grid[i][j] = "0"
                dfs(grid, i+1,j)
                dfs(grid, i-1, j)
                dfs(grid, i, j+1)
                dfs(grid, i, j-1)
            return True
                
                
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        if n == 0:
            return 0
        # Initializing
        self.res = 0
        # Union Find
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    self.res += 1
                    dfs(grid, i, j)
        return self.res
        
# BFS method:
class Solution(object):           
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """            
        m = len(grid)
        if m == 0:
            return 0
        n = len(grid[0])
        if n == 0:
            return 0
        # Initializing
        future = []
        res = 0
        
        # Union Find
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    grid[i][j] = "0"
                    res += 1
                    future.append((i,j))
                    while future:
                        cur_i, cur_j = future.pop(0)
                        if cur_i >= 1 and grid[cur_i-1][cur_j] == "1":
                            grid[cur_i-1][cur_j] = "0"
                            future.append((cur_i-1, cur_j))
                        if cur_j >= 1 and grid[cur_i][cur_j-1] == "1":
                            grid[cur_i][cur_j-1] = "0"
                            future.append((cur_i, cur_j - 1))
                        if cur_i <= m - 2 and grid[cur_i+1][cur_j] == "1":
                            grid[cur_i+1][cur_j] = "0"
                            future.append((cur_i+1, cur_j))
                        if cur_j <= n - 2 and grid[cur_i][cur_j+1] == "1":
                            grid[cur_i][cur_j+1] = "0"
                            future.append((cur_i, cur_j + 1))
        return res
