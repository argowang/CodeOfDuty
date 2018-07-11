class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # if len(nums) == 1:
        #     return nums[0]
        # dic = {}
        # for i in nums:
        #     if i in dic:
        #         dic[i] += 1
        #         if dic[i] > len(nums)/2 :
        #             return i
        #     else:
        #         dic[i] = 1
        count = 0
        candidate = None
        for i in nums:
            if count == 0:
                candidate = i
            if candidate == i:
                count += 1
            else:
                count -= 1
        return candidate
        
        