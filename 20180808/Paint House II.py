class Solution(object):
    def minCostII(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        # The algorithm could take O(N *2K), since there is only one time we expand the for loop inside O(NK), which is actually O(N * 2K).
        # Space is O(2K), but we can still reduce it to constant; we only use a cost to represent current cost, since at every layer, we only want to get the minimum cost and its index and the second min value.
        # So after optimizing, our algorithm takd O(NK) time and O(1) space:
        n = len(costs)
        if n == 0:
            return 0

        # Initialize
        prev_min1, prev_min2, prev_idx = 0, 0, -1
        for i in range(n):
            cur_min1, cur_min2, cur_idx = float('inf'),float('inf'), -1
            for k in range(len(costs[0])):
                cost = costs[i][k]
                # If the color is the same as the last layer, find another min color for last layer and the add to current layer
                if k == prev_idx:
                    cost += prev_min2
                else:
                    cost += prev_min1   
                # Find the min value in current layer
                if cost < cur_min1:
                    # Remember to update min2 whenever update min1.
                    cur_min2 = cur_min1
                    cur_min1 = cost
                    cur_idx = k
                elif cost < cur_min2:
                    cur_min2 = cost
                    
            prev_min1 = cur_min1
            prev_min2 = cur_min2
            prev_idx = cur_idx
        return prev_min1
            
        