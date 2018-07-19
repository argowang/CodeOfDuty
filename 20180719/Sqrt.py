class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        sta, end = 1, x
        ans = 0
        while sta <=  end:
            mid = (sta + end) / 2
            if mid * mid <= x:
                sta = mid + 1
                ans = mid
            elif mid * mid > x:
                end = mid - 1
        return ans
    