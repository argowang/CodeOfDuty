class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        # logn reminds me of binary search
        if not nums:
            return -1
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) / 2
            if nums[mid] == target:
                return mid
            # Two cases: either nums[mid] >= nums[low](low -> mid is sorted) 
            # or nums[mid] <nums[high](mid -> high is sorted)
            if nums[low] <= nums[mid]:
                # low -> mid is sorted, ordinary binary search
                if nums[low] <= target <= nums[mid]:
                    high = mid - 1
                # targt is in another range
                else:
                    low = mid + 1
            else:
                # mid -> high is sorted, ordinary binary search
                if nums[mid] <= target <= nums[high]:
                    low = mid + 1
                else:
                    high = mid - 1
        return -1 