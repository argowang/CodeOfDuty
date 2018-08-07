class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        # n = len(costs)
        # if n == 0:
        #     return 0
        # # Use a 2d matrix to store the accumulate cost; row represents accumulate costs of previous houses, while column represent the color of current house.
        # # Initiate dp with the costs
        # dp = [[cost for cost in house] for house in costs]
        # for idx in range(1, n):
        #     for color in range(3):
        #         dp[idx][color] = costs[idx][color] + min(dp[idx-1][(color - 1) % 3],dp[idx-1][(color + 1) % 3] )
        # return min(dp[-1])
    
    
        # cleaner version:
        # Constant Space, O(n) time.
        n = len(costs)
        if n == 0:
            return 0
        r, b, g = costs[0][0], costs[0][1], costs[0][2]
        for i in range(1, n):
            r_pre, b_pre = r, b
            r = costs[i][0] + min(b, g)
            b = costs[i][1] + min(r_pre, g)
            g = costs[i][2] + min(r_pre, b_pre)
        return min(min(r,b), g)
                    
                    
        