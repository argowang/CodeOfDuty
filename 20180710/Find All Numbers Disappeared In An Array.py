class Solution(object):
    def exchange(self,a,b):
        return b,a
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # I am so stupid to make this so complicated..
        # for i in range(len(nums)):
        #     while nums[i] != i + 1 and nums[nums[i] - 1] != nums[i]:
        #         nums[nums[i] - 1] , nums[i]= self.exchange(nums[nums[i] - 1],nums[i])
        # return [i+1 for i in range(len(nums)) if i + 1 != nums[i]]
        length = len(nums)
        nums = set(nums)
        res = []
        for i in range(length):
            if i + 1 not in nums:
                res.append(i + 1)
        return res
        