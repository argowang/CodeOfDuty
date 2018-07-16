class Solution(object):
    def reverse(self, nums, sta, end):
        for i in range((end - sta)/2 + 1):
            tmp = nums[i + sta]
            nums[i + sta] = nums[end - i]
            nums[end - i] = tmp
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if k > len(nums):
            k = (k - len(nums)) % len(nums)
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, len(nums) - 1)
        
        # or O(n) extra space:
        # res = [i for i in nums]
        # for i in range(len(nums)):
        #   nums[i] = nums[(i + k) % len(nums)]