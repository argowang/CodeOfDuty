class Solution(object):
    def exchange(self, a, b):
        return b, a
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        # if len(nums) == 2:
        #     if nums[0] > nums[1]:
        #         nums[0], nums[1] = self.exchange(nums[0], nums[1])
        # if len(nums) > 2:
        #     for i in range(1, len(nums) - 1):
        #         if i % 2 == 1:
        #             if nums[i] < max(nums[i-1], nums[i + 1]):
        #                 if nums[i-1] > nums[i+1]:
        #                     nums[i], nums[i-1] = self.exchange(nums[i], nums[i-1])
        #                 else:
        #                     nums[i], nums[i+1] = self.exchange(nums[i], nums[i+1])
        #         else:
        #             if nums[i] > min(nums[i-1], nums[i + 1]):
        #                 if nums[i-1] < nums[i+1]:
        #                     nums[i], nums[i-1] = self.exchange(nums[i], nums[i-1])
        #                 else:
        #                     nums[i], nums[i+1] = self.exchange(nums[i], nums[i+1])
        nums.sort()
        flag = False
        for i in range(len(nums) - 1):
            flag = not flag
            if flag:
                if nums[i] > nums[i+1]:
                    nums[i], nums[i+1] = self.exchange(nums[i], nums[i+1])
            else:
                if nums[i] < nums[i+1]:
                    nums[i], nums[i+1] = self.exchange(nums[i], nums[i+1])
        
