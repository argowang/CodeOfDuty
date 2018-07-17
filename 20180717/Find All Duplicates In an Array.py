class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        # for i in range(len(nums)):
        #     while( nums[i] != i + 1 and nums[nums[i] - 1] != nums[i]):
        #         tmp = nums[nums[i] - 1]
        #         nums[nums[i] - 1] = nums[i]
        #         nums[i] = tmp
        # res = []
        # for i in range(len(nums)):
        #     if nums[i] != i + 1:
        #         res.append(nums[i])
        # return res
        res = []
        for n in nums:
            if nums[abs(n) - 1] < 0:
                res.append(abs(n))        
            else:
                nums[abs(n) - 1] *= -1
        return res

                
        