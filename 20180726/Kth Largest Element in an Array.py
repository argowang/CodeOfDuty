class Solution(object):
    # Random Select algorithm
    def partition(self, nums, start, end):
        pivot = random.randrange(start, end+1)
        pv = nums[pivot]
        nums[end], nums[pivot] = nums[pivot], nums[end]
        i = start - 1
        j = start
        while j <= end:
            if nums[j] >= pv:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
            j += 1
        return i
    
    def quickselect(self, nums, start, end, k):
        if start == end:
            return nums[start]
        pos = self.partition(nums, start, end)
        if pos == k - 1:
            return nums[pos]
        elif pos > k-1:
            return self.quickselect(nums, start, pos - 1, k)
        else:
            return self.quickselect(nums, pos + 1, end, k)

            
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        val = self.quickselect(nums, 0, len(nums) - 1, k)
        return val

        
        