class Solution(object):
    def binarySearch(self, nums, i, j, target):
        if i >= j:
            if nums[i] < target:
                return i + 1
            else:
                return i
        else:
            mid = (i + j) / 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                return self.binarySearch(nums, i, mid - 1, target)
            else:
                return self.binarySearch(nums, mid + 1, j, target)
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.binarySearch(nums, 0, len(nums) - 1, target)
        