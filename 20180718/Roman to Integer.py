class Solution(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        # res = 0
        # dic = {"I":1, "V":5, "X":10, "L": 50, "C": 100, "D":500, "M":1000}
        # for i in range(len(s)):
        #     if s[i] == "I" and i < len(s) - 1:
        #         if s[i+1] == "V" or s[i+1] == "X":
        #             res -= 1
        #         else:
        #             res += 1
        #     elif s[i] == "X" and i < len(s) - 1:
        #         if s[i+1] == "L" or s[i+1] == "C":
        #             res -= 10
        #         else:
        #             res += 10
        #     elif s[i] == "C" and i < len(s) - 1:
        #         if s[i+1] == "D" or s[i+1] == "M":
        #             res -= 100
        #         else:
        #             res += 100
        #     else:
        #         res += dic[s[i]]
        # return res
        d = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
        num, pre = 0, 1000
        for i in [d[j] for j in s]:
            num += i
            if i > pre:
                num -= 2*pre
            pre = i
        return num
                    
                    
            
        