class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        # Similar to Divide 2 integers:
#         if n == 0:
#             return 1
#         base = x
#         power = 0
#         res = 1
#         while power < abs(n):
#             tmp_base = base
#             tmp_power = 1
#             while tmp_power * 2 + power <= abs(n):
#                 tmp_base = tmp_base * tmp_base
#                 tmp_power *= 2
#             power += tmp_power
#             res *= tmp_base
#         return res if n > 0 else 1/res
            
        # bit manipulation:
        # we can first exchange n into binary, for example, n = 9 = 1001, when x = 2, our ans = 2^8 * 2^1
        # So the idea is, whenever we met "1", we multiple update ans
        # if n == 0:
        #     return 1
        # ans = 1
        # bin_n = abs(n)
        # while bin_n > 0:
        #     if bin_n & 1 == 1:
        #         ans *= x
        #     bin_n >>= 1
        #     x *= x
        # return ans if n > 0 else 1/ans
    
        # More cleaner:
        if n == 0:
            return 1
        if n < 0:
            n = -n
            x = 1/x
        return self.myPow(x*x, n/2) if n % 2 == 0 else x * self.myPow(x*x, n/2)
        
        
            
        