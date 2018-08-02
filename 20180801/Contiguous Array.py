class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # accumulate sum: count
        # count_j - count_i = sum of count (nums[i:j+1])
        # met 0: count - 1; met 1: count + 1
        count = 0
        res = 0
        # use a map to store count and number of that occurs:
        # Initialize the map, for case of [0,1] or [1,0]
        # if count = 0, which means that there is equal 1 and 0:
        map = {0: -1}
        for i in range(len(nums)):
            if nums[i] == 0:
                count -= 1
            else:
                count += 1
            # index that has the same count means that they have the same number of 0 and 1; which means that there is [0,1] couples between them.
            if count in map:
                res = max(res, i - map[count])
            else:
                map[count] = i
        return res
