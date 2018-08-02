class Solution(object):
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        positive = (dividend > 0) is (divisor > 0)
        res = 0
        dividend, divisor = abs(dividend), abs(divisor)
        while dividend >= divisor:
            # Slow Start idea:
            # every time that dismatch the following, re-declare tmp and i
            tmp, i = divisor, 1
            while dividend >= tmp:
                dividend -= tmp
                res += i
                i <<= 1
                tmp <<= 1
        if not positive:
            res = -res
        # be careful that the max integer is 2147483647, since one bit is used for '0'
        return min(max(-2147483648, res), 2147483647)
        
        