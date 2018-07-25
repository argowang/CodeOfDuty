## DFS Method
class Solution(object):
    def dfs(self, nums, start, n, used, res, buf):
        if start == n:
            # DO NOT APPEND A LIST OR JSON!!! USE DEEP COPY.
            res.append(copy.copy(buf))
            return res
        
        for i in range(n):
            if not used[i]:
                buf.append(nums[i]) 
                start += 1
                used[i] = True
                self.dfs(nums, start, n, used, res, buf)
                buf.pop()
                # Set ith to False for next iteration. For example, if nums = [a, b, c], currently we are at "b" ([a,b]);
                # The recursive iteration first take "c" and append one possible result and then pop the buf; 
                # Now we want to let the pointer go to "c" so that we can enter [a,c] round. 
                # Since we set used[2] to True already , we need to reset it to False so that next iteration can pass "c" to bf.
                used[i] = False
                start -= 1
                
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n = len(nums)
        if n == 0:
            return nums
        res = []
        nums.sort()
        used = [False for _ in nums]
        buf = []
        self.dfs(nums, 0, n, used, res, buf)
        return res
        
## Swap Method:
class Solution(object):
    def swap(self, nums, start, n, res):
        if start == n:
            res.append(copy.copy(nums))
            return res
        for i in range(start, n):
            if i != 0 and nums[i] == nums[i-1]:
                continue
            nums[start], nums[i] = nums[i], nums[start]
            start += 1
            self.swap(nums, start, n, res)
            start -= 1
            nums[start], nums[i] = nums[i], nums[start]
            
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n = len(nums)
        if n == 0:
            return nums
        res = []
        nums.sort()
        self.swap(nums, 0, n, res)
        return res
        
        
# None Recursive Method:
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        n = len(nums)
        if n == 0:
            return []
        elif n == 1:
            return [nums]
        nums.sort()
        res = [[nums[0]]]
        for i in range(1, n):
            new = []
            for cur in res:
                for num in range(len(cur)):
                    if nums[i] != cur[num]:
                        new.append(cur[:num] + [nums[i]] + cur[num:])
                new.append(cur[:]+ [nums[i]])
            res = copy.copy(new)
        return res
                        
                
        
        
               
        