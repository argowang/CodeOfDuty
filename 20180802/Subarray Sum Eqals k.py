class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # O(n2) time complexity and O(1) Space complexity
        # res = 0
        # for i in range(len(nums)):
        #     sum = 0
        #     for j in range(i, len(nums)):
        #         sum += nums[j]
        #         if sum == k:
        #             res += 1
        # return res

        
        # O(n) time complexity and O(x) space complexity
        # Use map, key is the cumulated sum and value is the number of that sum occurs
        # Idea: if cumulate sum at end - cumulate sum at start = k, which means that subsequence[i:j+1] has sum that equals to k. We use map to store the number of that cumulate sum which have occured. for example, if k = 0 and the taversed string is [0,0,0], sum = 0 has occured 3 times. the next one is also 0; then [0], [0,0], [0,0,0], [0,0,0,0]  is all satisfied.
        map = {}
        res = 0
        sum = 0
        for cur in nums:
            sum += cur
            if sum == k:
                res += 1
            if sum - k in map:
                res += map[sum-k]
            # increase the value (number of the time that the key occurs):
            if sum in map:
                map[sum] += 1
            else:
                map[sum] = 1
        return res
 
        
                
