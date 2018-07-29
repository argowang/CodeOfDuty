class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        dp = [0 for i in range(len(s) + 1)]
        n = len(s)
        dp[n] = 1
        if s[-1] == "0":
            dp[n-1] = 0
        else:
            dp[n-1] = 1
        for i in range(n-2, -1, -1):
            if s[i] == "0":
                continue
            if int(s[i:i+2]) <= 26:
                dp[i] = dp[i+1] + dp[i+2]
            else:
                dp[i] = dp[i+1]
        return dp[0]
