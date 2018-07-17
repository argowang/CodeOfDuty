class Solution(object):
    # def change_basetwo(self, x):
    #     res = []
    #     while x / 2 != 0:
    #         res.append(x % 2)
    #         x = x / 2
    #     res.append(x % 2)
    #     return res[::-1]
    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        # basetwo_x = self.change_basetwo(x)
        # basetwo_y = self.change_basetwo(y)
        # longer = basetwo_x if len(basetwo_x) >= len(basetwo_y) else basetwo_y
        # shorter = basetwo_y if len(basetwo_y) <= len(basetwo_x) else basetwo_x
        # dis = 0
        # print(longer)
        # print(shorter)
        # for i in range(len(longer) - len(shorter)):
        #     if longer[i] == 1:
        #         dis += 1
        # for i in range(len(shorter)):
        #     idx_longer = len(longer) - len(shorter) + i
        #     if longer[idx_longer] != shorter[i]:
        #         dis += 1
        # return dis
        n = x ^ y
        res = 0
        while n:
            if n&1 == 1:
                res += 1
            n >>= 1
        return res