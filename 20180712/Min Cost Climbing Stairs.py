class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        # dp = [0] * len(cost)
        # for i in range(2,len(dp),1):
        #     dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        # return min(dp[-1] + cost[-1], dp[-2] + cost[-2])
        if len(cost) < 3:
            return min(cost)
        cost.append(0)
        for i in range(2, len(cost), 1):
            cost[i] += min(cost[i-1], cost[i-2])
        return cost[-1]        