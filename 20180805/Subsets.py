class Solution(object):
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        # Back Tracking:
        # def helper(length, count, nums, path, res):
        #     if count == length:
        #         res.append(path[:])
        #         return res
        #     helper(length, count + 1, nums[1:], path, res)
        #     helper(length, count + 1, nums[1:], path + [nums[0]], res)
        # res = []
        # length = len(nums)
        # helper(length, 0, nums, [], res)
        # return res
        
        # Bit Manipulation:
        # The idea is: for example in our cases [1,2,3], we could have 2^3 -1 = 7 subset
        # We let an index i indicates current number, i could be: 0, 1, 10, 11, 101, 110, 111
        # j represents the idx of the nums; so 1 << j could be: 1, 10, 100
        # As long as i & 1 << j != 0, we append nums[j] into current list.
        res = []
        for i in range( 1 << len(nums)):
            tmp = []
            for j in xrange(len(nums)):
                if i & 1 << j != 0:
                    tmp.append(nums[j])
            res.append(tmp)
        return res