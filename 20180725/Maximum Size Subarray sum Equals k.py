class Solution(object):
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        mp = {0:-1}
        ans, acc = 0,0
        for i in range(len(nums)):
            acc += nums[i]
            if acc not in mp:
                mp[acc] = i
            if acc-k in mp:
                ans = max(ans, i-mp[acc-k])
        return ans
    