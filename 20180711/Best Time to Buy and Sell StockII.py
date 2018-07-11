class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        pro = 0
        for i in range(1, len(prices), 1):
            if(prices[i] > prices[i-1]):
                pro += prices[i] - prices[i-1]
        return pro