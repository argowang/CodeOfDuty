class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n == 0:
            return 0
        elif n == 1:
            return nums[0]
        
        # Use an array to store the maximum product of arrays who contains the last element.
#         dp = [0 for i in nums]
#         dp[0], min_p  = nums[0], nums[0]
#         ans = dp[0]
#         for i in range(1, n):
#             if nums[i] >= 0:
#                 dp[i] = max(nums[i], dp[i-1] * nums[i])
#                 min_p = min(nums[i], min_p * nums[i])
#             else:
#                 dp[i] = max(nums[i], nums[i] * min_p)
#                 min_p = min(nums[i], dp[i-1] * nums[i])
#             ans = max(ans, dp[i])
#         return ans
    
        # Or using constant space:
        max_p, min_p, ans = nums[0], nums[0],nums[0]
        for i in range(1, n):
            if nums[i] >= 0:
                max_p = max(nums[i], max_p * nums[i])
                min_p = min(nums[i], min_p * nums[i])
            else:
                tmp = max_p
                max_p = max(nums[i], nums[i] * min_p)
                min_p = min(nums[i], tmp * nums[i])
            ans = max(ans, max_p)
        return ans

        