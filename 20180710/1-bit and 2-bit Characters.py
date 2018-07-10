class Solution(object):
    def isOneBitCharacter(self, bits):
        """
        :type bits: List[int]
        :rtype: bool
        """
        # Why this one is faster?
        # idx = 0
        # while idx < len(bits):
        #     if bits[idx] == 1:
        #         idx += 2
        #     else:
        #         if idx == len(bits) - 1:
        #             return True
        #         else:
        #             idx += 1
        # return False
        idx, size = 0, len(bits)
        while idx < size - 1:
            idx += bits[idx] + 1
        return idx == size - 1
        