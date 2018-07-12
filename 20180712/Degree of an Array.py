class Solution(object):
    def findShortestSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dic = {}
        for i in range(len(nums)):
            if nums[i] in dic:
                dic[nums[i]].append(i)
            else:
                dic[nums[i]] = [i]
        frequency = 0
        res = len(nums)
        for key, value in dic.items():
            if (len(value) > frequency):
                frequency = len(value)
                res = value[-1] - value [0] + 1
            elif( len(value) == frequency):
                res = min(res, value[-1] - value [0] + 1)
        return res
        