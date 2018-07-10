class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        origin_r = len(nums)
        if origin_r < 1:
            return nums
        origin_c = len(nums[0])
        if origin_c * origin_r != r * c:
            return nums
        expand = [item for row in nums for item in row]
        return [[expand[col + ( c * row)] for col in range(c)] for row in range(r)]