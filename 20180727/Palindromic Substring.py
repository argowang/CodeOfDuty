class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        # O(n2) DP solution
        # m = len(s)
        # dp = [[False for _ in range(m)] for _ in range(m)]
        # for i in range(m):
        #     dp[i][i] = True
        # res = m
        # for i in range(m-2, -1, -1):
        #     for j in range(i + 1, m):
        #         if j == i + 1:
        #             dp [i][j] = dp[i+1][j] and s[i] == s[j]
        #         else:
        #             dp[i][j] = dp[i+1][j-1] and s[i] == s[j]
        #         if dp[i][j]:
        #             res += 1
        # return res
        
        # Manacher's Solution:
        # Expand the original string:
        A = "$#" + "#".join(s) + "#@"
        m = len(A)
        P = [0 for i in range(m)]
        C = R = 0
        for i in range(1, m-1):
            mirr = 2 * C - i
            if i < R:
                P[i] = min(R - i, P[mirr])
            while A[i - (1 + P[i])] == A[i + (1 + P[i])]:
                P[i] += 1
            if i + P[i] > R:
                C = i
                R = i + P[i]
        return sum([ (v + 1)/2 for v in P])

