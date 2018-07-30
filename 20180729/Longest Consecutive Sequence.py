# Hashset method O(n)
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        numset = set(nums)
        longestlen = 0
        
        for cur in nums:
            # find the begining of longest consecutive sequence:
            if cur - 1 not in numset:
                current_nums = cur
                currentlen = 1
            
                while current_nums + 1 in numset:
                    current_nums = current_nums + 1
                    currentlen += 1
                    
                longestlen = max(longestlen, currentlen)
        return longestlen

# Union Find method O(n log*n) nearly O(n)
class Union:
    def __init__(self,nums):
        self.length = len(nums)
        self.parent = [i for i in range(len(nums))]
        # Use rank to store the level of consecutive string
        self.rank = [1 for i in nums]
        self.highestrank = 1
        
    def find(self, idx):
        while self.parent[idx] != idx:
            idx = self.parent[idx]
        return idx
    
    def union(self, idx_x, idx_y):
        parentx_idx = self.find(idx_x)
        parenty_idx = self.find(idx_y)
        if parentx_idx == parenty_idx:
            return True
        else:
            # mark the one have longer consecutive string as parent
            # Update the rank of the parent
            if self.rank[parentx_idx] < self.rank[parenty_idx]:
                self.parent[parentx_idx] = parenty_idx
                self.rank[parenty_idx] += self.rank[parentx_idx]
                self.highestrank = max(self.highestrank, self.rank[parenty_idx])
            else:
                self.parent[parenty_idx] = parentx_idx
                self.rank[parentx_idx] += self.rank[parenty_idx]
                self.highestrank = max(self.highestrank, self.rank[parentx_idx])
        return True
    
    def getHighest(self):
        return self.highestrank
                    
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Use hashmap to save the number that has already occured.
        numset = {}
        if len(nums) == 0:
            return 0
        union = Union(nums)
        
        for i in range(len(nums)):
            # find the begining of longest consecutive sequence:
            if nums[i] in numset:
                # Save time for duplicate value
                continue
            if nums[i] - 1 in numset:
                union.union(i, numset[nums[i]-1])
            if nums[i] + 1 in numset:
                union.union(i, numset[nums[i]+1])
            numset[nums[i]] = i
            
        return union.getHighest()
