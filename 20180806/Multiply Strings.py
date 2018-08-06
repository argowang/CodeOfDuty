class Solution(object):
#     def convertToInt(self, num):
#         n = len(num)
#         dic = {"0":0, "1":1, "2":2, "3":3, "4":4, "5":5, "6":6, "7":7, "8":8, "9":9}
#         ans = dic[num[0]]
#         if n == 1:
#             return ans
#         idx = 1
#         while idx < n:
#             ans *= 10
#             ans += dic[num[idx]]
#             idx += 1
#         return ans
    
#     def convertToStr(self, num):
#         dic = {0:"0", 1:"1", 2:"2", 3:"3", 4:"4", 5:"5", 6:"6", 7:"7", 8:"8", 9:"9"}
#         ans = []
#         while num != 0:
#             ans.append(dic[num % 10])
#             num /= 10
#         return "".join(ans[::-1])
        
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        # if num1 == "0" or num2 == "0":
        #     return "0"
        # int1 = self.convertToInt(num1)
        # int2 = self.convertToInt(num2)
        # res = int1 * int2
        # return self.convertToStr(res)
        
        m = len(num1)
        n = len(num2)
        res = [0] * (m+n)
        # From end to front
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                mul = (ord(num1[i]) - ord('0')) * (ord(num2[j]) - ord('0'))
                # In case mul % 10 + res[i+j+1] > 10, use a temp variable to store the total value, in case it bigger than 9.
                # First update the higher index
                cur_sum = mul + res[i+j+1]
                res[i+j+1] = cur_sum % 10
                res[i+j] += cur_sum / 10     

        ans = []
        for s in res:
            if not (len(ans) == 0 and s == 0):
                ans.append(str(s))
        return "0" if len(ans) == 0 else "".join(ans)
    
    