class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        nums.sort()
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                else:
                    res.append([nums[i], nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while l < r and  nums[l] == nums[l-1]:
                        l += 1
                    while l < r and nums[r] == nums[r+1]:
                        r -= 1
        return res
            
# No Duplicate nums:
def threeSumNoDup(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    res = []

    for i in range(len(nums) - 2):
        myset = set()
        for j in range(i+1, len(nums)):
            if -(nums[i] + nums[j]) in myset:
                res.append([nums[i], nums[j], -(nums[i] + nums[j])])
            myset.add(nums[j])

    return res
print(threeSumNoDup([-1,4,6,2,5,7,3,-2, -2]))    