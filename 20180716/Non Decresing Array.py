class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        ans = None
        for i in range(1, len(nums)):
            if nums[i] < nums[i-1]:
                if ans != None:
                    return False
                ans = i - 1
        return ans == 0 or ans == len(nums) - 2 or ans== None or nums[ans - 1] <= nums[ans + 1] or nums[ans] <= nums[ans + 2] 
