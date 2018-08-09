class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # Use a stack to store the left bound:
        # # O(n) time and O(n) space...
        # stack = []
        # l = -1
        # res = 0
        # for r in range(len(height)):
        #     # Append to the stack whenever current value bigger than 0
        #     if height[r] > 0:
        #         if len(stack) != 0:
        #             if height[r] < height[stack[-1]]:
        #                 l = stack[-1]
        #                 res += (r-l-1) * height[r]
        #             else:
        #                 # Use a barrier indicate the current axis.
        #                 # Every time we pop a left bound, we elevate the axis to the value of that left bound
        #                 barrier = 0
        #                 while len(stack) != 0 and height[stack[-1]] <= height[r]:
        #                     l = stack.pop()
        #                     res += (r-l-1) * (height[l] - barrier)
        #                     barrier = height[l]
        #                 if len(stack) != 0 and height[stack[-1]] >= height[r]:
        #                     res += (r - stack[-1] - 1) * (height[r] - barrier)
        #         stack.append(r)
        # return res
        
        # Dynamic Programming:
        # O(3n) time and O(3n) Space method
        # ans = 0
        # left = [height[0] for i in height]
        # right = [height[-1] for i in height]
        # for idx in range(1, len(height)):
        #     left[idx] = max(left[idx - 1], height[idx])
        # for idx in range(len(height)-2, -1, -1):
        #     right[idx] = max(right[idx + 1], height[idx])
        # for cur in range(len(height)):
        #     ans += min(left[cur], right[cur]) - height[cur]
        # return ans  
        
        # Two Pointer, idea is the same as DP:
        ans = 0
        left, right, left_max, right_max = 0, len(height) - 1, 0, 0
        while left <= right:
            # when left_max > right_max, the water traped depends upon right_max; similar as opposite case. 
            if height[left] <= height[right]:
                if height[left] < left_max:
                    ans += left_max - height[left]
                else:
                    left_max = height[left]
                left += 1
            else:
                if height[right] <= right_max:
                    ans += right_max - height[right] 
                else:
                    right_max = height[right]
                right -= 1
        return ans
            
        