class Solution(object):
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        myset = set(nums)
        res = 0
        if k == 0:
            for i in myset:
                if nums.count(i) > 1:
                    res += 1
        elif k > 0:
            for i in myset:
                if i+k in myset:
                    res += 1
        return res
        
        
        
