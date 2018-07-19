class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(needle) == 0 or haystack == needle:
            return 0
        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i] == needle[0] and haystack[i: i + len(needle) ] == needle[:]:
                return i
        return -1
        