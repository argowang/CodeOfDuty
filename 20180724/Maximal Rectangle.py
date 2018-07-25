class Solution(object):
    # Use Left and Right Boundary
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        n =  len(matrix[0])
        res = [[0 for i in row] for row in matrix]
        height = [0 for i in matrix[0]]
        left = [0 for i in matrix[0]]
        right = [n for i in matrix[0]]
        maximum = 0
        for row in range(len(matrix)):
            cur_left = 0
            for i in range(n):
                if matrix[row][i] == "1":
                    # Take the previous row's left boundary into consideration
                    left[i] = max(left[i], cur_left)
                else:
                    left[i] = 0
                    cur_left = i + 1
            cur_right = n
            for i in range(n - 1, -1, -1):
                if matrix[row][i] == "1":
                    right[i] = min(right[i], cur_right)
                else:
                    right[i] = n
                    cur_right = i
            for i in range(n):
                if matrix[row][i] == "1":
                    height[i] += 1
                else:
                    height[i] = 0
            for i in range(n):
                res[row][i] = (right[i] - left[i]) * height[i]
                maximum = max(res[row][i], maximum)
        return maximum
    # Saving space:
    def maximalRectangle(self, matrix):
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        n = len(matrix[0])
        res = 0
        height = [0 for i in range(n+1)]
        for i in range(len(matrix)):
            b = []
            for j in range(n+1):
                if j < n:
                    if matrix[i][j] == "1":
                        height[j] += 1
                    else:
                        height[j] = 0
                while b and height[b[-1]] > height[j]:
                    pj = b.pop()
                    width = j if not b else j - b[-1] - 1
                    res = max( height[pj] * width, res)
                b.append(j)
        return res
            
                
        