class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        # Counting Sort
        # count = [0 for i in range(3)]
        # for i in nums:
        #     count[i] += 1
        # idx = 0
        # for i in range(len(count)):
        #     while count[i] > 0:
        #         nums[idx] = i
        #         count[i] -= 1
        #         idx +=1
        
        # One-pass:
        # Use head to indicate the right boundary index of "0"
        # use mid to indicate the length index of "1"
        
        # head = -1
        # mid = 0
        # j = 0
        # p = len(nums) - 1
        # while j <= p:
        #     if nums[j] == 0:
        #         head += 1
        #         if head + mid != j:
        #             nums[head], nums[head+mid] = nums[head+mid], nums[head]
        #         nums[head], nums[j] = nums[j], nums[head]
        #     elif nums[j] == 1:
        #         mid += 1
        #         nums[head+mid], nums[j] = nums[j], nums[head+mid]
        #     j += 1
        
        # Cleaner:
        low, mid = 0, 0
        high = len(nums) - 1
        while mid <= high:
            if nums[mid] == 0:
                nums[low], nums[mid] = nums[mid], nums[low]
                low += 1
                mid += 1
            elif nums[mid] == 1:
                mid += 1
            else:
                nums[high], nums[mid] = nums[mid], nums[high]
                high -= 1

           
            
        
                    
        
        